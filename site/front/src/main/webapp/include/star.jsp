 <%@ page language="java" contentType="text/html; charset=utf-8"%>
 <div class="modal fade" id="commentModalDialog" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title" id="commentModalTitle">
               	评论
            </h4>
         </div>
         <div class="modal-body tc" id="commentModalBody">
            <textarea rows="5" cols="70" id="commentTextarea" placeholder="请输入评论"></textarea>
            <div class="fl mt40 mb10 col-sm-12">
            <input id="commentGrade" value="4" type="number" 
            class="rating" min=0 max=5 step=0.2 data-size="lg">
            </div>
         </div>
         <div class="modal-footer tc">
            <button type="button" class="btn btn-default mr20" 
               data-dismiss="modal" id="commentModalCancel">取消
            </button>
            <button type="button" class="btn btn-primary ml20" data-dismiss="modal" 
            id="commentModalOk">
               	确定
            </button>
         </div>
      </div><!-- /.modal-content -->
</div></div><!-- /.modal -->