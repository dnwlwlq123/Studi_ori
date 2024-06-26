package freeBoard.service;

import freeBoard.bean.FBoardDTO;
import freeBoard.bean.FBoardCommentDTO;
import freeBoard.dao.FBoardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FBoardServiceImpl implements FBoardService{
    @Autowired
    private FBoardDAO fBoardDAO;

    @Override
    public void write(FBoardDTO fBoardDTO) {
        fBoardDAO.write(fBoardDTO);
    }

    @Override
    public List<FBoardDTO> getFBoardList(int page) {
        int startNum = (page-1)*5;
        int size = 5;
        // 1page 0 ~ 4  / 2page 5 ~ 9
        return fBoardDAO.getFBoardList(startNum, size);
    }

    @Override
    public void updateLike(String num, String userId) {
        Map<String, Object> map = new HashMap<>();
        map.put("fBoard", Integer.parseInt(num));
        map.put("userId", userId);
        fBoardDAO.updateLike(map);
    }

    @Override
    public List<Integer> getUserLikeList(String userId) {
        return fBoardDAO.getUserLikeList(userId);
    }

    @Override
    public List<FBoardCommentDTO> getBoardComment(int fBoard) {
        return fBoardDAO.getBoardComment(fBoard);
    }

    @Override
    public List<FBoardCommentDTO> addComment(FBoardCommentDTO fBoardCommentDTO) {
        fBoardDAO.addComment(fBoardCommentDTO);
        return fBoardDAO.getBoardComment(fBoardCommentDTO.getFBoard());
    }

    @Override
    public List<FBoardDTO> fBoardList(int page) {
        int startNum = (page-1)*5;
        int size = 5;
        // 1page 0 ~ 4  / 2page 5 ~ 9
        return fBoardDAO.fBoardList(startNum, size);
    }

    @Override
    public List<FBoardDTO> getFBoardTopRank(int number) {
        return fBoardDAO.getFBoardTopRank(number);

    }

    @Override
    public void deleteFBoard(int fBoard) {
        fBoardDAO.deleteFBoard(fBoard);
    }
}
