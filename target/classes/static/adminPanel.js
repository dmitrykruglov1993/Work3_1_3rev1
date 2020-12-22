$(function () {

  getAllUsers();

  let newUserForm = $("#newUserForm");

  newUserForm.submit(function (event) {
    event.preventDefault();
    let newUser = {
      username: $("#newUserUsername").val(),
      password: $("#newUserPassword").val(),
      roles: $("#newUserRoles").val()
    };
    $.ajax({
      url: newUserForm.attr("action"),
      method: "POST",
      contentType: 'application/json',
      data: JSON.stringify(newUser),
      success: function () {
        $('#usersTable tbody').empty();
        getAllUsers();
      }
    });
    $("#newUserFormResetButton").trigger("click");
    alert("User " + $("#newUserUsername").val() + " saved");
  });

  let editUserForm = $("#editUserForm");

  editUserForm.submit(function (event) {
    event.preventDefault();
    let editUser = {
      id: $("#editUserId").val(),
      username: $("#editUserUsername").val(),
      password: $("#editUserPassword").val(),
      roles: $("#editUserRoles").val()
    };
    $.ajax({
      url: editUserForm.attr("action"),
      method: "PUT",
      contentType: 'application/json',
      data: JSON.stringify(editUser),
      success: function () {
        $('#usersTable tbody').empty();
        getAllUsers();
      }
    });
    $("#editUserCloseButton").trigger("click");
  })
});

function getAllUsers() {
  $.ajax({
    url: "/admin/users/all",
    method: "GET",
    success: function (data) {
      for (let i = 0; i < data.length; i++) {
        let user = data[i];
        let userRoles = user.roles;
        let rolesString = "";
        for (let j = 0; j < userRoles.length; j++) {
          rolesString += userRoles[j].role + " ";
        }
        var newTr = $("<tr id='tr" + user.id + "'></tr>");
        var newTrTd = "";
        newTrTd += "<td>" + user.id + "</td>";
        newTrTd += "<td id='td" + user.id + "username'>" + user.username
            + "</td>";
        newTrTd += "<td id='td" + user.id + "password'>" + user.password
            + "</td>";
        newTrTd += "<td id='td" + user.id + "roles'>" + rolesString + "</td>";
        newTrTd += "<td><div class='btn-group mr-sm-1'><button class='btn btn-primary' data-toggle='modal' data-target='#editUserModal' onclick='openEditUserModal("
            + user.id + ")' data-userId='" + user.id + "'>Edit</button></div>" +
            "<div class='btn-group'><button class='btn btn-danger' data-userId='"
            + user.id + "' onclick='removeUser(" + user.id
            + ")'>Delete</button></div></td>";
        newTr.html(newTrTd);
        $("#usersTableBody").append(newTr);
      }
    }
  });
}

function removeUser(id) {
  $("tr#tr" + id).remove();
  $.ajax({
    url: "/admin/delete/" + id,
    method: "DELETE",
  });
}

function openEditUserModal(id) {
  $("#editUserResetButton").trigger("click");

  $("#editUserModalHeader").text("Edit user " + $("#td" + id + "username").text());
  $("#editUserId").attr("value", id);
  $("#editUserUsername").val($("#td" + id + "username").text());
  $("#editUserPassword").val($("#td" + id + "password").text());
}