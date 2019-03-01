'use strict';
function load(){

	let submit = document.getElementById("submit");
	submit.addEventListener("click", checkData);
}

// Validates the data
function checkData(){
    let street = document.getElementById("street").value;
    if(street != "" && isNaN(street)){
        display(street);
    } else {
        const divSelect = document.getElementById("info");
        // clear the div
        divSelect.innerHTML = "";
        let ul = document.createElement("ul");
        let error = document.createElement("li");
        error.innerHTML = "Please enter a string.";
        ul.appendChild(error);
        divSelect.appendChild(ul);
    }
}
// Handles the fetch and querey portion
function display(street){
    
    
  var encodedURL ="";
  const apiUrl = 'https://data.winnipeg.ca/resource/h367-iifg.json?' +
                  `$where=lower(primary_street) LIKE lower('%${street}%')` +
                  '&$order=date_closed_to ASC' +
                  '&$limit=100';
  encodedURL = encodeURI(apiUrl);
  console.log(encodedURL);
    

fetch(encodedURL)
  .then(function(result) {
    return result.json(); 
  })
  .then(function(result) {  
    createStreet(result);
    
  });
}

// handles the data when no results are found. Calls displayData if results are found
function createStreet(result){
    
  console.log("in create Street", result);
  console.log("length : ", result.length);
  
  const divSelect = document.getElementById("info");
  // clear the div
  divSelect.innerHTML = "";
  
  if(result.length == 0){
    let ul = document.createElement("ul");
    let error = document.createElement("li");
    error.innerHTML = "No street closures at this time.";
    ul.appendChild(error);
    divSelect.appendChild(ul);
  
  } else{

    displayData(result);
  }
}

// Displays the results into a list 
function displayData(result){
    
    const divSelect = document.getElementById("info");
    for(let i = 0 ; i < result.length ; i++){
        // create ul 
        let ul = document.createElement("ul");

        // create li elements 
        let primary = document.createElement("li");
        primary.innerHTML = "Primary Street: " + result[i].primary_street;
        let bound = document.createElement("li");
        bound.innerHTML = "Closed from: " + result[i].boundaries;
        let closedTo = document.createElement("li");
        closedTo.innerHTML = "Date of re-open: " + result[i].date_closed_to.substr(0, result[i].date_closed_to.indexOf('T'));
        let direction = document.createElement("li");
        direction.innerHTML = "Direction: " + result[i].direction;
        let cross = document.createElement("li");
        cross.innerHTML = "Cross Street: " + result[i].cross_street;

        ul.appendChild(primary);
        ul.appendChild(cross);
        ul.appendChild(bound);
        ul.appendChild(direction);
        ul.appendChild(closedTo);
        divSelect.appendChild(ul);
    }
}

document.addEventListener('DOMContentLoaded', load);