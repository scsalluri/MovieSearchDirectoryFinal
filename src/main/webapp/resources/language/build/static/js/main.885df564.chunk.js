(this["webpackJsonpmy-app"]=this["webpackJsonpmy-app"]||[]).push([[0],{36:function(e,a,t){},37:function(e,a,t){},62:function(e,a,t){"use strict";t.r(a);var n=t(0),c=t.n(n),s=t(26),i=t.n(s),l=(t(36),t(37),t(28)),r=t(2),o=t(11),d=t(12),g=t(10),u=t(31),h=t(30),j=t(27),m=t.n(j),b=new(function(){function e(){Object(o.a)(this,e)}return Object(d.a)(e,[{key:"addLanguage",value:function(e){return m.a.post("http://localhost:8080/save_language",e)}}]),e}()),p=t(1),O=function(e){Object(u.a)(t,e);var a=Object(h.a)(t);function t(e){var n;return Object(o.a)(this,t),(n=a.call(this,e)).backToAdminPage=function(e){e.preventDefault(),window.location.replace("http://localhost:8080/adminPage")},n.saveOrUpdateEmployee=function(e){e.preventDefault();var a={languageName:n.state.languageName};console.log("language => "+JSON.stringify(a)),b.addLanguage(a).then((function(e){var a=e.data,t=JSON.stringify(a);document.getElementById("resvalue").innerHTML='"success"'===t?"Language Added Successfully":"Language Already Exists"}))},n.changeLanguageNameHandler=function(e){n.setState({languageName:e.target.value})},n.state={languageName:""},n.changeLanguageNameHandler=n.changeLanguageNameHandler.bind(Object(g.a)(n)),n.saveOrUpdateEmployee=n.saveOrUpdateEmployee.bind(Object(g.a)(n)),n}return Object(d.a)(t,[{key:"componentDidMount",value:function(){this.state.id}},{key:"render",value:function(){return Object(p.jsxs)("div",{children:[Object(p.jsx)("h1",{className:"text-center",style:{marginTop:"150px",color:"white"},children:Object(p.jsx)("b",{children:"Language Form"})}),Object(p.jsx)("br",{}),Object(p.jsx)("div",{className:"container",style:{marginRight:"380px",width:"800px"},children:Object(p.jsx)("div",{className:"row",style:{width:"1100px",height:"300px"},children:Object(p.jsx)("div",{className:"card col-md-6 offset-md-3 offset-md-3",children:Object(p.jsx)("div",{className:"card-body",children:Object(p.jsxs)("form",{children:[Object(p.jsxs)("div",{className:"form-group",children:[Object(p.jsx)("h3",{style:{marginTop:"50px"},children:"Language "}),Object(p.jsx)("input",{placeholder:"Enter Language ",name:"languageName",style:{marginTop:"20px",height:"50px"},className:"form-control",value:this.state.languageName,onChange:this.changeLanguageNameHandler})]}),Object(p.jsx)("div",{className:"form-group",children:Object(p.jsx)("h4",{id:"resvalue"})}),Object(p.jsxs)("div",{className:"card-body",style:{marginLeft:"30%"},children:[Object(p.jsx)("button",{style:{height:"50px"},className:"btn btn-success",onClick:this.saveOrUpdateEmployee,children:"Submit"}),Object(p.jsx)("button",{style:{height:"50px",marginLeft:"10px"},className:"btn btn-danger",onClick:this.backToAdminPage,children:"Cancel"})]})]})})})})})]})}}]),t}(n.Component);var x=function(){return Object(p.jsx)("div",{children:Object(p.jsx)(l.a,{children:Object(p.jsx)("div",{className:"container",children:Object(p.jsx)(r.c,{children:Object(p.jsx)(r.a,{path:"/",component:O})})})})})};i.a.render(Object(p.jsx)(c.a.StrictMode,{children:Object(p.jsx)(x,{})}),document.getElementById("root"))}},[[62,1,2]]]);
//# sourceMappingURL=main.885df564.chunk.js.map