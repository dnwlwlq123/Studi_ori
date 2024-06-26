<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-md-6 notice-section" style="display: none;"> <!-- 오른쪽 영역 -->
    <h4 class="mb-3">
        <span class="text-primary">신고 리스트</span>
    </h4>
    <div class="border border-primary-subtle rounded p-3">
        <div class="accordion accordion-flush" id="accordion2">
            <div class="accordion-item">
                <h2 class="accordion-header">
                    <button class="accordion-button collapsed" data-bs-toggle="collapse" data-bs-target="#flush-collapseTwo" aria-expanded="false" aria-controls="flush-collapseTwo">
                        모두보기
                    </button>
                </h2>
                <div id="flush-collapseTwo" class="accordion-collapse collapse" data-bs-parent="#accordion2">
                    <div class="accordion-body" id="reportList">
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<div class="col-md-6 notice-section" style="display: none;"> <!-- 오른쪽 영역 -->
    <h4 class="mb-3">
        <span class="text-primary">공지사항</span>
        <button type="button" class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target="#noticeWriteModal">새글쓰기</button>
    </h4>
    <div class="border border-primary-subtle rounded p-3">
        <div class="d-grid gap-2 noti-container">
            <c:forEach items="${notiList}" var="noti">
            <div class="d-flex justify-content-between align-items-center">
                <a href="#" class="font-large">${noti.title}</a>
                <div>
                    <a href="" class="notiDeleteBtn">delete</a>
                    <input type="hidden" value="${noti.noti_id}">
                </div>
            </div>
            <p class="font-large mb-0 d-inline-block text-truncate">${noti.content}</p>
            <hr>
            </c:forEach>
        </div>
<%--        <p class="font-large mb-0">공지사항 내용</p>
        <button class="btn btn-outline-*">모두보기</button>--%>
    </div>
</div>

<%--신고 모달--%>
<div class="modal fade" id="reportModal" tabindex="-1" aria-labelledby="reportModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body" id="reportContent">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" id="reportSaveBtn">Save changes</button>
            </div>
        </div>
    </div>
</div>

<%-- 공지사항 작성 모달 --%>
<div class="modal fade" id="noticeWriteModal" tabindex="-1" aria-labelledby="noticeWriteModal" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">공지사항</h1>
                <button type="button" class="btn-close"  data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form id="notiWriteForm">
                    <div class="mb-3">
                        <label for="noti-title" class="col-form-label">제목:</label>
                        <input type="text" class="form-control" name="title" id="noti-title">
                    </div>
                    <div class="mb-3">
                        <label for="noti-content" class="form-label">내용</label>
                        <textarea class="form-control" id="noti-content" name="content" rows="10"></textarea>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" onclick="notiWriteForm();">Send message</button>
            </div>
        </div>
    </div>
</div>
<script>
    function notiWriteForm(){
        var modalTile = $('#noti-title').val();
        var modalContent = $('#noti-conten').val();
        $.post({
            url: '/admin/managerPage/noti',
            data: $('#notiWriteForm').serialize(),
            success: function (){
                alert('등록되었습니다.');
                location.reload();
                /*$('.btn-close').click();
                var value =
                    `<div class="d-flex justify-content-between align-items-center">
                <a href="#" class="font-large">`+modalTile+`</a>
                <div>
                    <a href="" class="notiDeleteBtn">delete</a>
                    <input type="hidden" value="`+modalTile+`">
                </div>
                </div>
                <p class="font-large mb-0 d-inline-block text-truncate">`+modalContent+`</p>
                    <hr>`
                $('.noti-container').append(value);*/
            }
        })
    }

    $(document).ready(function (){
        $('.notiDeleteBtn').on('click', function (){
            $.post({
                url: "${pageContext.request.contextPath}/admin/noti/delete",
                data: "id=" + $(this).siblings('input[type="hidden"]').val(),
                success: function (){
                    alert('삭제되었습니다.')
                    location.reload();
                }
            })
        })
    })
</script>
