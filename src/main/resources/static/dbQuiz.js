function allCheck(){
	let id = document.getElementById('id');
	let pw = document.getElementById('pw');
	confirm = document.getElementById('confirm');
	userName = document.getElementById('userName');
	
	if(id.value == ""){
		alert('아이디는 필수 항목입니다.');
	}else if(pw.value == ""){
		alert('비밀번호는 필수 항목입니다.');
	}else if(confirm.value == ""){
		alert('비밀번호 확인은 필수 항목입니다.');
	}else if(userName.value == ""){
		alert('이름은 필수 항목입니다.');
	}else{
		var f = document.getElementById('f');
		f.submit();
	}
}

function pwCheck(){
	let pw = document.getElementById('pw');
	confirm = document.getElementById('confirm');
	label = document.getElementById('label');
	 if(pw.value == confirm.value){
		 label.innerHTML = '일치'
	 }else{
		 label.innerHTML = '불일치'
	 }
	// window.alert('pwCheck 호출')
}

function loginCheck(){
	let id = document.getElementById('id');
	let pw = document.getElementById('pw');
	
	if(id.value == ""){
		alert('아이디는 필수 항목입니다.');
	}else if(pw.value == ""){
		alert('비밀번호는 필수 항목입니다.');
	}else{
		var f = document.getElementById('f');
		f.submit();
	}
}

function getSelectedDeleteCheckboxes() {
	let checkboxes = document.getElementsByClassName('member-checkbox');
	let selectedValues = [];
	
	if (window.confirm("정말로 삭제하시겠습니까?")) {
		for (let i = 0; i < checkboxes.length; i++) {
			if (checkboxes[i].checked) {
				selectedValues.push(checkboxes[i].value);
			}
		}
		
		if(selectedValues[0] == null || selectedValues[0] == "") {
			window.confirm("삭제할 회원을 선택해주세요.")
		}else{
			const url="memberDelete";
			getCheckBoxesData(url, selectedValues);
		}
	}
}


function getBoardDeleteCheckboxes() { 
	let checkboxes = document.getElementsByClassName('member-checkbox');
	let selectedValues = [];
			
	if (window.confirm("정말로 삭제하시겠습니까?")) {
		for (let i = 0; i < checkboxes.length; i++) {
			if (checkboxes[i].checked) {
				selectedValues.push(checkboxes[i].value);
			}
		}
		if(selectedValues[0] == null || selectedValues[0] == "") {
			window.confirm("삭제할 회원을 선택해주세요.")
		}else{
			const url="boardDelete";
			getCheckBoxesData(url, selectedValues);
		}
	}
}

function getCheckBoxesData(url, selectedValues) {
	const data = document.createElement('input');
	data.setAttribute('type', 'hidden');
	data.setAttribute('name', 'selectedValues'); // 데이터의 key
	data.setAttribute('value', selectedValues); // 데이터의 value
			               	                  
	const form = document.createElement('form');
	form.setAttribute('method', 'post'); // 전송 방식 결정 (get or post)
	form.setAttribute('action', url); // 전송할 url 지정  
	form.appendChild(data);
	document.body.appendChild(form);
	form.submit();  
}
       
    
function getSelectedEmailCheckboxes() {
	let checkboxes = document.getElementsByClassName('member-checkbox');
	let selectedValues = [];
	
	for (let i = 0; i < checkboxes.length; i++) {
		if (checkboxes[i].checked) {
			selectedValues.push(checkboxes[i].value);
		}
	}	
	if(selectedValues[0] == null || selectedValues[0] == "") {
		window.confirm("메일을 보낼 회원을 선택해주세요.")
	}else{
		const url="amemberSend";
		getCheckBoxesData(url, selectedValues);
	}
}

function fileTitle() {
	const fileInput = document.getElementById('emailFile');
	const fileTextarea = document.getElementById('fileTextarea');
	
	if (fileInput.files.length > 0) {
		const emailFile = fileInput.files[0].name;
		fileTextarea.value = emailFile;
	}
}

var xhr;
function sendEmail(){
	var userEmail = document.getElementById('userEmail').value;
	var emailTitle = document.getElementById('emailTitle').value;
	var emailContent = document.getElementById('emailContent').value;
	var fileInput = document.getElementById('emailFile');
	var emailFile = fileInput.files[0];
	
	var formData = new FormData();
	formData.append('userEmail', userEmail);
	formData.append('emailTitle', emailTitle);
	formData.append('emailContent', emailContent);
	
	if (emailFile) {
        formData.append('emailFile', emailFile);
    }
    
	var xhr = new XMLHttpRequest();
	xhr.open('POST', 'sendEmail');
	xhr.onreadystatechange = function () {
		if (xhr.readyState === 4 && xhr.status === 200) {
			location.href=xhr.responseText
		}
	};
	xhr.send(formData);
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
	
	
function commentDelete(commentId) {
    if (confirm("댓글을 삭제하시겠습니까?")) {
        // 서버로 삭제 요청 보내기 (AJAX 또는 Fetch API 사용)
        fetch(`/deleteComment?commentId=${commentId}`, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json',
            },
        })
        .then(response => {
            if (response.ok) {
                // 삭제 성공한 경우, 댓글 UI 업데이트 등 필요한 작업 수행
                location.reload(); // 예시로 페이지 새로고침
            } else {
                console.error('댓글 삭제 실패');
            }
        })
        .catch(error => {
            console.error('댓글 삭제 오류', error);
        });
    }
    }
}
