(this["webpackJsonpmy-app"]=this["webpackJsonpmy-app"]||[]).push([[0],{36:function(e,t,n){},37:function(e,t,n){},62:function(e,t,n){"use strict";n.r(t);var a=n(0),c=n.n(a),r=n(26),s=n.n(r),i=(n(36),n(37),n(28)),l=n(2),d=n(11),o=n(12),h=n(10),j=n(31),m=n(30),b=n(27),p=n.n(b),u=new(function(){function e(){Object(d.a)(this,e)}return Object(o.a)(e,[{key:"addGenre",value:function(e){return p.a.post("http://localhost:8080/save_genre",e)}}]),e}()),O=n(1),x=function(e){Object(j.a)(n,e);var t=Object(m.a)(n);function n(e){var a;return Object(d.a)(this,n),(a=t.call(this,e)).backToAdminPage=function(e){e.preventDefault(),window.location.replace("http://localhost:8080/adminPage")},a.saveOrUpdateEmployee=function(e){e.preventDefault();var t={genreName:a.state.genreName};console.log("genre => "+JSON.stringify(t)),u.addGenre(t).then((function(e){var t=e.data,n=JSON.stringify(t);document.getElementById("resvalue").innerHTML='"success"'===n?"Genre Added Successfully":"Genre Already Exists"}))},a.changeGenreNameHandler=function(e){a.setState({genreName:e.target.value})},a.state={genreName:""},a.changeGenreNameHandler=a.changeGenreNameHandler.bind(Object(h.a)(a)),a.saveOrUpdateEmployee=a.saveOrUpdateEmployee.bind(Object(h.a)(a)),a}return Object(o.a)(n,[{key:"componentDidMount",value:function(){this.state.id}},{key:"render",value:function(){return Object(O.jsxs)("div",{children:[Object(O.jsx)("h1",{className:"text-center",style:{marginTop:"150px",color:"white"},children:Object(O.jsx)("b",{children:"Genre Form"})}),Object(O.jsx)("br",{}),Object(O.jsx)("div",{className:"container",style:{marginRight:"380px",width:"800px"},children:Object(O.jsx)("div",{className:"row",style:{width:"1100px",height:"300px"},children:Object(O.jsx)("div",{className:"card col-md-6 offset-md-3 offset-md-3",children:Object(O.jsx)("div",{className:"card-body",children:Object(O.jsxs)("form",{children:[Object(O.jsxs)("div",{className:"form-group",children:[Object(O.jsx)("h3",{style:{marginTop:"50px"},children:"Genre"}),Object(O.jsx)("input",{placeholder:"Enter Genre ",name:"genreName",style:{marginTop:"20px",height:"50px"},className:"form-control",value:this.state.genreName,onChange:this.changeGenreNameHandler})]}),Object(O.jsx)("div",{className:"form-group",children:Object(O.jsx)("h4",{id:"resvalue"})}),Object(O.jsxs)("div",{className:"card-body",style:{marginLeft:"30%"},children:[Object(O.jsx)("button",{style:{height:"50px"},className:"btn btn-success",onClick:this.saveOrUpdateEmployee,children:"Submit"}),Object(O.jsx)("button",{style:{height:"50px",marginLeft:"10px"},className:"btn btn-danger",onClick:this.backToAdminPage,children:"Cancel"})]})]})})})})})]})}}]),n}(a.Component);var g=function(){return Object(O.jsx)("div",{children:Object(O.jsx)(i.a,{children:Object(O.jsx)("div",{className:"container",children:Object(O.jsx)(l.c,{children:Object(O.jsx)(l.a,{path:"/",component:x})})})})})};s.a.render(Object(O.jsx)(c.a.StrictMode,{children:Object(O.jsx)(g,{})}),document.getElementById("root"))}},[[62,1,2]]]);
//# sourceMappingURL=main.3f67d96a.chunk.js.map