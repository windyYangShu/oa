<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- 对于头部，尾部和首页这三个页面还是需要单独设置el表达式和路径信息的，因为这三个是最基础的三个jsp -->
<%@ page isELIgnored="false" %>
<%

    request.setAttribute("ctx", basePath);
%>


<!-- 配合top上面没写全的两个结束符号 -->
</section>
</div>

<style>
    /* demo page styles */
    body { min-height: 2300px; }

    .content-header b,
    .admin-form .panel.heading-border:before,
    .admin-form .panel .heading-border:before {
        transition: all 0.7s ease;
    }
    /* responsive demo styles */
    @media (max-width: 800px) {
        .admin-form .panel-body { padding: 18px 12px; }
    }
</style>

<style>
    .ui-datepicker select.ui-datepicker-month,
    .ui-datepicker select.ui-datepicker-year {
        width: 48%;
        margin-top: 0;
        margin-bottom: 0;

        line-height: 25px;
        text-indent: 3px;

        color: #888;
        border-color: #DDD;
        background-color: #FDFDFD;

        -webkit-appearance: none; /*Optionally disable dropdown arrow*/
    }
</style>

<script src="${ctx}vendor/jquery/jquery-1.11.1.min.js"></script>
<script src="${ctx}vendor/jquery/jquery_ui/jquery-ui.min.js"></script>
<script src="${ctx}assets/admin-tools/admin-forms/js/jquery.validate.min.js"></script>
<script src="${ctx}assets/admin-tools/admin-forms/js/additional-methods.min.js"></script>
<script src="${ctx}assets/admin-tools/admin-forms/js/jquery-ui-datepicker.min.js"></script>
<script src="${ctx}assets/js/utility/utility.js"></script>
<script src="${ctx}assets/js/demo/demo.js"></script>
<script src="${ctx}assets/js/main.js"></script>
<script type="text/javascript" src="${ctx}js/pages.js"></script>
<script type="text/javascript" src="${ctx}js/items.js"></script>

</body>
</html>


