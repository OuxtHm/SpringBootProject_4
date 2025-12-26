const {defineStore} = Pinia

const useBoardInsertStore = defineStore('board_insert', {
	// 공통으로 사용하는 데이터 설정 => static 변수
	// 받는 변수 (JSP), 서버에서 결과값
	state:()=>({
		// 받는 변수
		name:'',
		subject:'',
		content:'',
		pwd:'',
		// 서버에서 결과값
		msg:''
	}),
	// 서버와 연동
	actions:{
		// insert => 유효성 검사(NOT NULL = 반드시 입력이 되게 만든다) 
		// 비동기 처리 => async
		
	}
	



})