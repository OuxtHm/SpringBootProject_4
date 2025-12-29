const {defineStore} = Pinia

const useMemberStore = defineStore('member', {
	state:()=>({
		id:'',
		name:'',
		pwd:'',
		ifLogin:false
		
	}),
	actions:{
		async login(idRef, pwdRef){
			if(this.id==='')
			{
				idRef?.focus()
				return 
			}
			if(this.pwd==='')
			{
				pwdRef?.focus()
				return
			}
			
			const res= await axios.get('http://localhost:8080/member/login_vue/', {
				params:{
					id:this.id,
					pwd:this.pwd
				}
			})
			if(res.data.msg==='OK')
			{
				this.id=res.data.id
				this.name=res.data.name
				this.isLogin=true
				location.href="/main"
			}
			else if(res.data.msg==='NOID')
			{
				alert("ID가 존재하지 않습니다.")
				this.id=''
				this.pwd=''
			}
			else if(res.data.msg==='NOPWD')
			{
				alert("비밀번호가 일치하지 않습니다.")	
				this.pwd=''
			}
		},
		async logout(){
			const res=await axios.get('http://localhost:8080/member/logout_vue/')
			this.id=''
			this.name=''
			this.pwd=''
		}
	}
})