const {defineStore} = Pinia

const useBoardUpdateStore = defineStore('board_update', {
	// 공통으로 사용하는 데이터 설정 => static 변수
	// 받는 변수 (JSP), 서버에서 결과값
	state:()=>({
		// 받는 변수
		name:'',
		subject:'',
		content:'',
		pwd:'',
		// 서버에서 결과값
		msg:'',
		no:0,
		vo:{}
	}),
	// 서버와 연동
	actions:{
		// insert => 유효성 검사(NOT NULL = 반드시 입력이 되게 만든다) 
		// 비동기 처리 => async
		async boardUpdate({nameRef, subRef, contRef, pwdRef}){
			if(this.name==='')	// jsp 파일의 v-model 값을 비교
			{
				nameRef.focus()
				return
			}
			if(this.subject==='')	// jsp 파일의 v-model 값을 비교
			{
				subRef.focus()
				return
			}
			if(this.content==='')	// jsp 파일의 v-model 값을 비교
			{
				contRef.focus()
				return
			}
			if(this.pwd==='')	// jsp 파일의 v-model 값을 비교
			{
				pwdRef.focus()
				return
			}
			
			const res=await axios.put('http://localhost:8080/board/update_ok_vue/',{
				name:this.name,
				subject:this.subject,
				content:this.content,
				pwd:this.pwd,
				no:this.no
			})
			
			if(res.data.msg==='yes')
			{
				location.href="/board/detail?no="+this.no	
			}
			else
			{
				alert("수정에 실패하셨습니다.")
				this.pwd=''
				pwdRef.focus()
			}
		},
		async boardUpdateData(no){
			const res=await axios.get('http://localhost:8080/board/update_vue/', {
				params:{
					no:no
				}
			})
			this.vo=res.data
			this.no=res.data.no
			this.name=res.data.name
			this.subject=res.data.subject
			this.content=res.data.content
		}
	}
	
})