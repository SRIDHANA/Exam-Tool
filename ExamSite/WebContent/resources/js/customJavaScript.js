

// https://www.w3schools.com/howto/howto_js_filter_table.asp
// Accepts arguments as HTML element reference for Table field element, Search Input field element 
function crudTableSearchFilter(searchInputHtmlElement, tableHtmlElement) {
  // Declare variables 
  //var input, filter, table, tr, td, i;
  var filter, tr, td, i, j; 
  //input = document.getElementById("myInput");
  filter = searchInputHtmlElement.value.toUpperCase();
  //alert("Search Input: " + filter);
  //table = document.getElementById("myTable");
  tr = tableHtmlElement.getElementsByTagName("tr");
  
  // Loop through all table rows, and hide those who don't match the search query
  for (i = 1; i < tr.length; i++) { // Ignore the first row, since it is a table Header (i=1; represents that)
	var rowDisplay = false;
	td = tr[i].getElementsByTagName("td");
    for (j = 0; j < td.length-2; j++) { // Scan all td element's except last 2 td's which have Edit and delete button's (td.length-2 represents that)
      if (td[j] && td[j].innerHTML.toUpperCase().indexOf(filter) > -1) {
    	  rowDisplay = true;
    	  break;
	  }
    }
    if (rowDisplay) {
      tr[i].style.display = "";
    } else {
      tr[i].style.display = "none";
    }
  }
}