<!DOCTYPE html>
<html>
<head>
    <script type="text/javascript" src="/js/ckeditor4/ckeditor.js"></script>
</head>
<body>
<div height="135" style="padding:13px;padding-left:10px" colspan="5">
    <!--	<button onclick="show_imgs()">批量上传</button></br>-->
    <textarea name="textarea" id="strContent" style="width:652px;border:1px solid #ccc;height:300px;" cols="45" rows="5">在我这儿编辑！</textarea>
</div>

</body>
<script type="text/javascript">

    window.onload = function()
    {
        CKEDITOR.replace( 'strContent',{
            toolbar :
                    [
                        ['Source','Save','Templates','Cut','Copy','Paste','PasteText','PasteFromWord', 'SpellChecker','Scayt','Undo','Redo','Find','Replace','SelectAll','RemoveFormat','Form', 'Checkbox', 'Radio'],['TextField','Textarea','Select', 'Button', 'Bold','Italic','Underline','Strike','Subscript','Superscript','NumberedList','BulletedList','Outdent','Indent','Blockquote','JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock','Link','Unlink'],['Anchor','Image','Table','HorizontalRule','Smiley','SpecialChar','Styles','Format'],['Font','FontSize','TextColor','BGColor']
                    ]
        });
    };
</script>
</html>
