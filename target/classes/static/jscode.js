// $(function () {
//
//     getAllUsers();
//
//     let newUserForm = $("#newUserForm");
//
//     newUserForm.submit(function (event) {
//         event.preventDefault();
//         let newUser =
//             {
//                 name:($("#newUserUsername").val()),
//                 password: ($("#newUserPassword").val()),
//                 roleid:($("#newUserRoles").val())
//             };
//         $.ajax({
//             url: "/rest",
//             method: "POST",
//             contentType: 'application/json',
//             data:JSON.stringify(newUser),
//             success: function () {
//                 $('#tbody').empty();
//                 getAllUsers();
//             }
//         });
//         // $("#newUserFormResetButton").trigger("click");
//         // alert("User " + $("#newUserUsername").val() + " saved");
//     });
//
//     let editUserForm = $("#editUserForm");
//
//     editUserForm.submit(function (event) {
//         event.preventDefault();
//         let editUser = {
//             id: $("#editUserId").val(),
//             name: $("#editUserUsername").val(),
//             password: $("#editUserPassword").val(),
//             roles: $("#editUserRoles").val()
//         };
//         $.ajax({
//             url: "/rest",
//             method: "PUT",
//             contentType: 'application/json',
//             data: JSON.stringify(editUser),
//             success: function () {
//                 $('#tbody').empty();
//                 getAllUsers();
//             }
//         });
//         $("#editUserCloseButton").trigger("click");
//     })
// })
//
// function getAllUsers() {
//     $.ajax("/rest", {
//         dataType: "json",
//         success: function (data) {
//             data.forEach(function (el) {
//                 addUserInTableBody(el);
//             });
//         }
//     })
// }
//
//
// function removeUser(id) {
//     $("tr#tr" + id).remove();
//     $.ajax({
//         url:"/rest/delete" + id,
//         method:"DELETE",
//     });
// }
//
// function openEditUserModal(id) {
//     $("#editUserResetButton").trigger("click");
//
//     $("#editUserModalHeader").text("Edit user " + $("#td" + id + "username").text());
//     $("#editUserId").attr("value", id);
//     $("#editUserUsername").val($("#td" + id + "username").text());
//     $("#editUserPassword").val($("#td" + id + "password").text());
// }
//
// function addUserInTableBody(el) {
//     let trLocal = $("<tr></tr>").clone();
//
//
//     trLocal.attr("id", "tr" + el.id);
//     getTd(el.id, "name" + el.id).appendTo(trLocal);
//     getTd(el.name, "name" + el.id).appendTo(trLocal);
//     getRole(el.role, "role" + el.id).appendTo(trLocal);
//     $("<td><div class='btn-group mr-sm-1'><button class='btn btn-primary' data-toggle='modal' data-target='#editUserModal' onclick='openEditUserModal("
//         + el.id + ")' data-userId='" + el.id + "'>Edit</button></div></td>").appendTo(trLocal);
//     $("<td><div class='btn-group'><button class='btn btn-danger' data-userId='"
//         + el.id + "' onclick='removeUser(" + el.id
//         + ")'>Delete</button></div></td>").appendTo(trLocal);
//     trLocal.appendTo($("#tbody"));
// }
//
// let getTd = function (val, valueOfName) {
//     let tdLocal = $("<td></td>").clone();
//     tdLocal.attr("id", valueOfName)
//     return tdLocal.text(val);
// }
//
// let getRole = function (el) {
//     let selectLocal = $("<tr></tr>").clone();
//     el.forEach(function (role) {
//         $("<td></td>").clone().text(role.role).appendTo(selectLocal);
//     });
//     let tdLocal = $("<td></td>").clone();
//     selectLocal.appendTo(tdLocal);
//     return tdLocal;
// };
