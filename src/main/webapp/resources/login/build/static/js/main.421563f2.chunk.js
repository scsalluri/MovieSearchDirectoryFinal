(this["webpackJsonpreact-frontend"]=this["webpackJsonpreact-frontend"]||[]).push([[0],{35:function(e,a,t){},36:function(e,a,t){},65:function(e,a,t){"use strict";t.r(a);var n=t(1),s=t.n(n),r=t(28),c=t.n(r),l=(t(35),t(36),t(29)),i=t(2),d=t(9),o=t(10),u=t(12),h=t(11),m=t(0),j=function(e){Object(u.a)(t,e);var a=Object(h.a)(t);function t(e){var n;return Object(d.a)(this,t),(n=a.call(this,e)).state={},n}return Object(o.a)(t,[{key:"render",value:function(){return Object(m.jsx)("div",{children:Object(m.jsx)("header",{children:Object(m.jsx)("nav",{className:"navbar navbar-expand-md navbar-dark bg-dark",children:Object(m.jsx)("div",{className:"navbar-brand",children:"MOVIE SEARCH DIRECTORY"})})})})}}]),t}(n.Component),b=function(e){Object(u.a)(t,e);var a=Object(h.a)(t);function t(e){var n;return Object(d.a)(this,t),(n=a.call(this,e)).state={},n}return Object(o.a)(t,[{key:"render",value:function(){return Object(m.jsx)("div",{children:Object(m.jsx)("footer",{className:"footer",children:Object(m.jsx)("span",{className:"text-muted"})})})}}]),t}(n.Component),p=t(4),O=t(17),g=t.n(O),f=new(function(){function e(){Object(d.a)(this,e)}return Object(o.a)(e,[{key:"loginUser",value:function(e){return g.a.post("http://localhost:8080/login-user",e)}},{key:"createEmployee",value:function(e){return g.a.post("http://localhost:8080/save-user",e)}}]),e}()),v=function(e){Object(u.a)(t,e);var a=Object(h.a)(t);function t(e){var n;return Object(d.a)(this,t),(n=a.call(this,e)).saveOrUpdateEmployee=function(e){if(e.preventDefault(),document.getElementById("password").value===document.getElementById("repassword").value){var a={fullname:n.state.fullname,username:n.state.username,email:n.state.email,password:n.state.password};console.log("user => "+JSON.stringify(a)),f.createEmployee(a).then((function(e){var a=e.data,t=JSON.stringify(a);'"success"'===t?window.location.replace("http://localhost:8080/login"):document.getElementById("resvalue").innerHTML=t}))}else document.getElementById("resvalue").innerHTML="Password And Re-enter Password Should match"},n.changeUserNameHandler=function(e){n.setState({username:e.target.value})},n.changeFullNameHandler=function(e){n.setState({fullname:e.target.value})},n.changePasswordHandler=function(e){n.setState({password:e.target.value})},n.changeRepasswordHandler=function(e){n.setState({repassword:e.target.value})},n.changeEmailHandler=function(e){n.setState({email:e.target.value})},n.state={id:"",username:"",fullname:"",email:"",password:"",repassword:""},n.changeUserNameHandler=n.changeUserNameHandler.bind(Object(p.a)(n)),n.changeFullNameHandler=n.changeFullNameHandler.bind(Object(p.a)(n)),n.changeEmailHandler=n.changeEmailHandler.bind(Object(p.a)(n)),n.changePasswordHandler=n.changePasswordHandler.bind(Object(p.a)(n)),n.changeRepasswordHandler=n.changeRepasswordHandler.bind(Object(p.a)(n)),n.saveOrUpdateEmployee=n.saveOrUpdateEmployee.bind(Object(p.a)(n)),n}return Object(o.a)(t,[{key:"componentDidMount",value:function(){this.state.id}},{key:"cancel",value:function(){this.props.history.push("/")}},{key:"getTitle",value:function(){return"_add"===this.state.id?Object(m.jsx)("h3",{className:"text-center",children:"LOGIN"}):Object(m.jsx)("h3",{className:"text-center",children:"REGISTRATION"})}},{key:"render",value:function(){return Object(m.jsxs)("div",{children:[Object(m.jsx)("br",{}),Object(m.jsx)("div",{className:"container",style:{marginTop:"120px",marginLeft:"190px"},children:Object(m.jsx)("div",{className:"row",children:Object(m.jsxs)("div",{className:"card col-md-6 offset-md-3 offset-md-3",children:[this.getTitle(),Object(m.jsx)("div",{className:"card-body",children:Object(m.jsxs)("form",{children:[Object(m.jsxs)("div",{className:"form-group",children:[Object(m.jsx)("label",{children:" User Name: "}),Object(m.jsx)("input",{placeholder:"User Name",required:!0,name:"username",className:"form-control",value:this.state.userName,onChange:this.changeUserNameHandler})]}),Object(m.jsxs)("div",{className:"form-group",children:[Object(m.jsx)("label",{children:" Full Name: "}),Object(m.jsx)("input",{placeholder:"Full Name",required:!0,name:"fullname",className:"form-control",value:this.state.fullname,onChange:this.changeFullNameHandler})]}),Object(m.jsxs)("div",{className:"form-group",children:[Object(m.jsx)("label",{children:" Email Id: "}),Object(m.jsx)("input",{placeholder:"Email Address",required:!0,name:"email",className:"form-control",value:this.state.email,onChange:this.changeEmailHandler})]}),Object(m.jsxs)("div",{className:"form-group",children:[Object(m.jsx)("label",{children:" Password: "}),Object(m.jsx)("input",{placeholder:"Password",type:"password",required:!0,name:"password",id:"password",className:"form-control",value:this.state.password,onChange:this.changePasswordHandler})]}),Object(m.jsxs)("div",{className:"form-group",children:[Object(m.jsx)("label",{children:" Confirm Password: "}),Object(m.jsx)("input",{placeholder:"Re-Enter Password ",type:"password",required:!0,name:"repassword",id:"repassword",className:"form-control",value:this.state.repassword,onChange:this.changeRepasswordHandler})]}),Object(m.jsx)("div",{className:"form-group",children:Object(m.jsx)("h4",{id:"resvalue"})}),Object(m.jsx)("br",{}),Object(m.jsx)("button",{className:"btn btn-success",onClick:this.saveOrUpdateEmployee,style:{marginLeft:"10px",width:"80px"},children:"SignUp"}),Object(m.jsx)("button",{className:"btn btn-danger",onClick:this.cancel.bind(this),style:{marginLeft:"10px",width:"80px"},children:"Login"})]})})]})})})]})}}]),t}(n.Component),x=function(e){Object(u.a)(t,e);var a=Object(h.a)(t);function t(e){var n;return Object(d.a)(this,t),(n=a.call(this,e)).saveOrUpdateEmployee=function(e){e.preventDefault();var a={username:n.state.username,password:n.state.password};console.log("user => "+JSON.stringify(a)),f.loginUser(a).then((function(e){var a=e.data,t=JSON.stringify(a);'"Admin"'===t?window.location.replace("http://localhost:8080/adminPage"):'"registered"'===t?window.location.replace("http://localhost:8080/registeredUser"):document.getElementById("resvalue").innerHTML="Invalid UserName Or Password!!"}))},n.changeUserNameHandler=function(e){n.setState({username:e.target.value})},n.changePasswordHandler=function(e){n.setState({password:e.target.value})},n.cancel=function(e){e.preventDefault(),window.location.replace("http://localhost:8080")},n.state={username:"",password:""},n.changeUserNameHandler=n.changeUserNameHandler.bind(Object(p.a)(n)),n.changePasswordHandler=n.changePasswordHandler.bind(Object(p.a)(n)),n.saveOrUpdateEmployee=n.saveOrUpdateEmployee.bind(Object(p.a)(n)),n.addSignup=n.addSignup.bind(Object(p.a)(n)),n}return Object(o.a)(t,[{key:"componentDidMount",value:function(){this.state.id}},{key:"addSignup",value:function(){this.props.history.push("/save")}},{key:"getTitle",value:function(){return"_add"===this.state.id?Object(m.jsx)("h3",{className:"text-center",children:"Add Employee"}):Object(m.jsx)("h3",{className:"text-center",children:"LOGIN FORM"})}},{key:"render",value:function(){return Object(m.jsxs)("div",{children:[Object(m.jsx)("br",{}),Object(m.jsx)("div",{className:"container",style:{marginTop:"150px",marginLeft:"190px"},children:Object(m.jsx)("div",{className:"row",children:Object(m.jsxs)("div",{className:"card col-md-6 offset-md-3 offset-md-3",children:[this.getTitle(),Object(m.jsx)("div",{className:"card-body",children:Object(m.jsxs)("form",{children:[Object(m.jsxs)("div",{className:"form-group",children:[Object(m.jsx)("label",{children:" User Name: "}),Object(m.jsx)("input",{placeholder:"UserName",name:"username",className:"form-control",value:this.state.username,onChange:this.changeUserNameHandler})]}),Object(m.jsxs)("div",{className:"form-group",children:[Object(m.jsx)("label",{children:" Password: "}),Object(m.jsx)("input",{type:"password",placeholder:"Enter password",name:"password",className:"form-control",value:this.state.password,onChange:this.changePasswordHandler})]}),Object(m.jsx)("div",{className:"form-group",children:Object(m.jsx)("h4",{id:"resvalue"})}),Object(m.jsx)("br",{}),Object(m.jsx)("button",{className:"btn btn-success",onClick:this.saveOrUpdateEmployee,style:{marginLeft:"10px",width:"80px"},children:"Login"}),Object(m.jsx)("button",{className:"btn btn-primary",onClick:this.addSignup,style:{marginLeft:"10px",width:"80px"},children:"SignUp"}),Object(m.jsx)("button",{className:"btn btn-danger",onClick:this.cancel,style:{marginLeft:"10px",width:"80px"},children:"Back"})]})})]})})})]})}}]),t}(n.Component);var N=function(){return Object(m.jsx)("div",{children:Object(m.jsxs)(l.a,{children:[Object(m.jsx)(j,{}),Object(m.jsx)("div",{className:"container",style:{marginLeft:"350px"},children:Object(m.jsxs)(i.c,{children:[Object(m.jsx)(i.a,{path:"/save",exact:!0,component:v}),Object(m.jsx)(i.a,{path:"/",component:x})]})}),Object(m.jsx)(b,{})]})})},w=function(e){e&&e instanceof Function&&t.e(3).then(t.bind(null,66)).then((function(a){var t=a.getCLS,n=a.getFID,s=a.getFCP,r=a.getLCP,c=a.getTTFB;t(e),n(e),s(e),r(e),c(e)}))};t(64);c.a.render(Object(m.jsx)(s.a.StrictMode,{children:Object(m.jsx)(N,{})}),document.getElementById("root")),w()}},[[65,1,2]]]);
//# sourceMappingURL=main.421563f2.chunk.js.map