<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f7f7f7;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 80%;
            margin: 50px auto;
            background-color: white;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 20px;
            border-radius: 10px;
        }

        h1 {
            font-size: 2em;
            color: #333;
        }

        .logout-button {
            float: right;
            padding: 10px 20px;
            font-size: 1em;
            color: white;
            background-color: #ff4757;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .logout-button:hover {
            background-color: #e84118;
        }

        .add-record-button {
            padding: 10px 20px;
            font-size: 1em;
            color: white;
            background-color: #4CAF50;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 15px;
        }

        .add-record-button:hover {
            background-color: #45a049;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 15px;
            text-align: center;
        }

        th {
            background-color: #f2f2f2;
            font-weight: bold;
            color: #333;
        }

        td {
            background-color: #fff;
        }

        .actions button {
            padding: 8px 15px;
            font-size: 0.9em;
            margin: 0 5px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .btn-upload {
            background-color: #3498db;
            color: white;
        }

        .btn-delete {
            background-color: #ff6b6b;
            color: white;
        }

        .btn-upload:hover {
            background-color: #2980b9;
        }

        .btn-delete:hover {
            background-color: #ff4757;
        }

        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 30px;
        }

        .header h1 {
            margin: 0;
        }

        .table-container {
            overflow-x: auto;
        }

        @media (max-width: 768px) {
            .container {
                width: 95%;
            }

            th, td {
                padding: 10px;
            }

            .actions button {
                padding: 5px 10px;
            }
        }

        /* Modal Styles */
        .modal {
            display: none;
            position: fixed;
            z-index: 1;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0,0,0,0.5);
        }

        .modal-content {
            background-color: white;
            margin: 15% auto;
            padding: 20px;
            border-radius: 10px;
            width: 50%;
        }

        .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }

        .close:hover, .close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
        }

        textarea {
            width: 100%;
            height: 100px;
            padding: 10px;
            border-radius: 5px;
            border: 1px solid #ccc;
            font-size: 1em;
        }

        .save-button {
            padding: 10px 20px;
            font-size: 1em;
            color: white;
            background-color: #3498db;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 10px;
        }

        .save-button:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>Welcome, ${username}!</h1>
            <form action="./logout">
                <button class="logout-button" type="submit">Logout</button>
            </form>
        </div>

        <!-- Add Record Button -->
        <button class="add-record-button" id="addRecordBtn">Add New Record</button>

        <h2>Your Records</h2>
        <div class="table-container">
            <table>
                <thead>
                    <tr>
                        <th>Date</th>
                        <th>Description</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="record" items="${records}">
                        <tr>
                           <td><fmt:formatDate value="${record.date}" pattern="dd-MM-yyyy" timeZone="GMT+5:30"/></td>

                            <td>${record.description}</td>
                            <td class="actions">
                          <button class="btn-upload" onclick="openModal('${record.entryid}','${record.date}', '${record.description}', '${record.id}')">Update</button>
                                <form action="./deleteentry" method="post" style="display:inline;">
                                    <input type="hidden" id="entryId" name="entryId" value="${record.entryid}">
                                    <button type="submit" class="btn-delete">Delete</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
<!-- Modal for Add/Upload Record -->
<div id="addRecordModal" class="modal">
    <div class="modal-content">
        <span class="close">&times;</span>
        <h2 id="modalTitle">Add New Record</h2>
        <form id="recordForm" method="post">
        
		    <input type="hidden" id="entryid" name="entryid" value="0">
			<input type="hidden" id="recordId" name="id" value="0">
		  
		    <label for="date">Date:</label>
		    <input type="date" id="date" name="date" required>
		
		    <label for="description">Description:</label>
		    <textarea id="description" name="description" required></textarea>
		
		    <button type="submit" class="save-button" id="saveButton">Save</button>
		</form>
        
    </div>
</div>

<script>
    // Get modal element
    var modal = document.getElementById("addRecordModal");

    // Get the button that opens the modal for adding a new record
    var btn = document.getElementById("addRecordBtn");

    // Get the <span> element that closes the modal
    var span = document.getElementsByClassName("close")[0];

    // Get the form inside the modal
    var form = document.getElementById("recordForm");

    // When the user clicks the "Add New Record" button, open the modal for adding
    btn.onclick = function() {
        document.getElementById("modalTitle").innerText = "Add New Record";
        document.getElementById("date").value = "";
        document.getElementById("description").value = "";
       
        form.action = "./submitentry";  // Set form action for adding new record
        modal.style.display = "block";
    }

    // Open modal for uploading (updating) records
   function openModal(entryid, date, description, id) {
    	console.log(date);
    document.getElementById("modalTitle").innerText = "Upload Record";
    document.getElementById("entryid").value = entryid;
    document.getElementById("date").value = date;
    document.getElementById("description").value = description;
    document.getElementById("recordId").value = id;
    form.action = "./updateentry";  // Set form action for updating the record
    modal.style.display = "block";

}


    // When the user clicks on <span> (x), close the modal
    span.onclick = function() {
        modal.style.display = "none";
    }

    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
</script>

</body>
</html>
