// Functionality for the employees form
// Trevor Storey
// October 31st 2018


function load(){

	let submit = document.getElementById("calcButton");
	submit.addEventListener("click", checkData);

	let clear = document.getElementById("clearButton");
	clear.addEventListener("click", clearButton);

	if(localStorage.getItem("empData")){
		document.getElementById("list").innerHTML = localStorage.getItem("empData");
	}
}

function checkData(){
	let name = document.getElementById("fullName").value;
	let hours = document.getElementById("hoursWorked").value;
	let rate = document.getElementById("hourlyRate").value;

	hours = parseFloat(hours);
	rate = parseFloat(rate);
	if(name != "" && isNaN(hours) == false && isNaN(rate) == false){
		displayData(name, hours, rate);
	}
	resetFields();

}

function displayData(name, hours, rate){
	let tbody = document.getElementsByTagName("tbody")[0];

	let newTr = document.createElement("tr");
	let newName = document.createElement("td");
	let newGross = document.createElement("td");
	let newTax = document.createElement("td");
	let newNet = document.createElement("td");

	var grossPay;
	if(hours > 40)
	{
		var overtime = hours % 40;
		grossPay = ((hours - overtime) * rate) + (overtime * (rate * 1.5));
	} else 
	{
		grossPay = hours * rate;
	}

	var taxRate;
	if(grossPay < 250)
	{
		taxRate = 0.25;
	} else if (grossPay >= 250 && grossPay < 500) 
	{
		taxRate = 0.30;
	} else if (grossPay >= 500 && grossPay <= 750)
	{
		taxRate = 0.40;
	} else 
	{
		taxRate = 0.50;
	}
	
	var taxCharged = grossPay * taxRate;
	var netPay = grossPay - taxCharged;

	newName.innerHTML = name;
	newGross.innerHTML = "$" + grossPay.toFixed(2);
	newTax.innerHTML = "$" + taxCharged.toFixed(2);
	newNet.innerHTML = "$" + netPay.toFixed(2);
	
	newTr.appendChild(newName);
	newTr.appendChild(newGross);
	newTr.appendChild(newTax);
	newTr.appendChild(newNet);

	

	tbody.appendChild(newTr);
	saveListData();
}

function saveListData(){
	let tableData = document.getElementById("list").innerHTML;
	localStorage.setItem("empData", tableData);
}

function clearButton(){
	let tbody = document.getElementsByTagName("tbody")[0];
	while(tbody.firstChild){
		tbody.removeChild(tbody.firstChild);
	}

	resetFields();
	saveListData();
}

function resetFields(){
	document.getElementById("fullName").value = "";
	document.getElementById("hoursWorked").value = "";
	document.getElementById("hourlyRate").value = "";
	document.getElementById("fullName").focus();
}

document.addEventListener("DOMContentLoaded", load);