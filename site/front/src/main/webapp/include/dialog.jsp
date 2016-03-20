<%@page language="java" contentType="text/html; charset=utf-8"%>
<%--对话框 --%>
    <div class="modal fade" id="modalDialog" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title" id="modalTitle">
               模态框（Modal）标题
            </h4>
         </div>
         <div class="modal-body" id="modalBody">
            在这里添加一些文本
         </div>
         <div class="modal-footer tc">
            <button type="button" class="btn btn-default mr20" 
               data-dismiss="modal" id="modalCancel">取消
            </button>
            <button type="button" class="btn btn-primary ml20" data-dismiss="modal" id="modalOk">
               	确定
            </button>
         </div>
      </div><!-- /.modal-content -->
</div></div><!-- /.modal -->

<div class="modal fade" id="modalAlertDialog" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title" id="modalAlertTitle">
               模态框（Modal）标题
            </h4>
         </div>
         <div class="modal-body" id="modalAlertBody">
            在这里添加一些文本
         </div>
         <div class="modal-footer tc">
            <button type="button" class="btn btn-default mr20" 
               data-dismiss="modal" id="modalAlertCancel">取消
            </button>
            <button type="button" class="btn btn-primary ml20" data-dismiss="modal" id="modalAlertOk">
               	确定
            </button>
         </div>
      </div><!-- /.modal-content -->
</div></div><!-- /.modal -->