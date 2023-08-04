function allCheck(){
	var id = document.getElementById('id');
	var pw = document.getElementById('pw');
	var confirm = document.getElementById('confirm');
	var userName = document.getElementById('userName');
	if(id.value == ""){
		alert('아이디는 필수 항목입니다..');
	}else if(pw.value == ""){
		alert('비밀번호는 필수 항목입니다.')
	}else if(confirm.value == ""){
		alert('비밀번호 확인은 필수 항목입니다.')
	}else if(userName.value == ""){
		alert('이름은 필수 항목입니다.');
	}else{
		var f = document.getElementById('f');
		f.submit();
	}
}

function pwCheck(){
	pw = document.getElementById('pw');
	confirm = document.getElementById('confirm');
	label = document.getElementById('label');
	if(pw.value == confirm.value){
		label.innerHTML = '일치'
	} else {
		label.innerHTML = '불일치'
	}
}

function loginCheck(){
	let id = document.getElementById('id');
	let pw = document.getElementById('pw');
	if(id.value == ""){
		alert('아이디는 필수 항목입니다..');
	}else if(pw.value == ""){
		alert('비밀번호는 필수 항목입니다.')
	}else{
		var f = document.getElementById('f');
		f.submit();
	}
}

function fileURL() {
   const fileInput = document.getElementById('fileImg');
   const petImage = document.getElementById('img');

   if (fileInput.files.length > 0) {
      const fileURL = URL.createObjectURL(fileInput.files[0]);
      petImage.src = fileURL; 
   }
}

function uploadImage(){
   var fileInput = document.getElementById('fileImg');
   var imageFile = fileInput.files[0];
   
   var formData = new FormData();
   
   if (imageFile) {
        formData.append('imageFile', imageFile);
        formData.append('fileName', imageFile.name);
    }
    
   var xhr = new XMLHttpRequest();
   xhr.open('POST', 'uploadImage');
   xhr.onreadystatechange = function () {
      if (xhr.readyState === 4 && xhr.status === 200) {
         location.href=xhr.responseText
      }
   };
   xhr.send(formData);
}