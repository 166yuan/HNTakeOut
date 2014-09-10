var code ; //全局变量
     function createCode()  
     {   
       code = "";  
       var codeLength = 4;//验证码长度
       var checkCode = document.getElementById("checkCode");  
       var selectChar = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z');//���к�ѡ�����֤����ַ�ȻҲ���������ĵ�  
          
       for(var i=0;i<codeLength;i++)  
       {  
       var charIndex = Math.floor(Math.random()*36);  
       code +=selectChar[charIndex];  
       }  
//       alert(code);  
       if(checkCode)  
       {  
         checkCode.className="code";  
         checkCode.value = code;  
       }  
         
     }  
       
      function validate ()  
     {  
       var inputCode = document.getElementById("login_phrase").value;  
       if(inputCode.length <=0)  
       {  
           alert("请输入验证码");  
       }  
       else if(inputCode != code )  
       {  
          alert("验证码输入错误");  
          createCode();//ˢ����֤��  
       }  
       else  
       {  
    	    $.ajax({  
                type: "POST",  
                async:true,  
                url: "WebForm1.aspx/TestAjax",    //必须是后台的静态方法  
                contentType: "application/json; charset=utf-8",  
                dataType: "json",  
                //  data: "name=John&location=Boston",  
                data:"",  
                beforeSend: function () {  
                    bsl_showLoadingDialog("请稍等");  
                },  
                success: function (msg) {  
                    $(loadingDialog).dialog("close");  
                    alert("Data Saved: " + msg.d);  
                },  
                error: function (err) {  
                    $(loadingDialog).dialog("close");  
                    alert(err);  
                }  
            });  
       }  
         
       }  