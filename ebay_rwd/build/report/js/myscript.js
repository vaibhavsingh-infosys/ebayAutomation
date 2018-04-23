function load() {
	var mydata = jQuery.parseJSON(JSON.stringify(data));
	
	var table = document.createElement('table');
	for (var i = 0; i < mydata.length; i++){
	 
		var tr = document.createElement('tr');
	    var tr1 = document.createElement('tr');
	    var tr2 = document.createElement('tr');
	    var tr3 = document.createElement('tr');
	    var tr4 = document.createElement('tr');
	    var tr5 = document.createElement('tr');
	    var tr6 = document.createElement('tr');
	    var tr7 = document.createElement('tr');
	    
	    var td0 = document.createElement('td');
	    
	    var td1 = document.createElement('td');
	    var td2 = document.createElement('td');
	   
	    var td3 = document.createElement('td');
	    var td4 = document.createElement('td');
	   
	    var td5 = document.createElement('td');
	    var td6 = document.createElement('td');
	   
	    var td7 = document.createElement('td');
	    var td8 = document.createElement('td');
	   
	    var td9 = document.createElement('td');
	    var td10 = document.createElement('td');
	   
	    var td11 = document.createElement('td');
	    var td12 = document.createElement('td');
	   
	    var td13 = document.createElement('td');
	    var td14 = document.createElement('td');
	   
	    var text0 = document.createTextNode(mydata[i].testName);
	    
	    var text1 = document.createTextNode("Test Name");
	    var text2 = document.createTextNode(mydata[i].testName);
	   
	    var text3 = document.createTextNode("Test Status");
	    var text4 = document.createTextNode(mydata[i].testStatus);
	   
	    var text5 = document.createTextNode("Start Time");
	    var text6 = document.createTextNode(mydata[i].startTime);
	   
	    
	    var text7 = document.createTextNode("End Time");
	    var text8 = document.createTextNode(mydata[i].endTime);
	   
	    var text9 = document.createTextNode("Screen shot");
	    var text10 = document.createTextNode(mydata[i].scrURL);
	    
	    var DOM_img = document.createElement("img");
	    DOM_img.src = (mydata[i].scrURL).replace("build\\report\\", "")

	    var text11 = document.createTextNode("Message");
	    var text12 = document.createTextNode(mydata[i].msg);
	   
	    var text13 = document.createTextNode("Assert Messages");
	    var text14 = document.createTextNode(mydata[i].assertions);
	   
	    td0.colSpan = "2";
	    td0.appendChild(text0);
	    
	    td1.appendChild(text1);
	    td2.appendChild(text2);
	    
	    td3.appendChild(text3);
	    td4.appendChild(text4);
	    
	    td5.appendChild(text5);
	    td6.appendChild(text6);
	    
	    td7.appendChild(text7);
	    td8.appendChild(text8);
	    
	    td9.appendChild(text9);
	  //  td10.appendChild(text10);
	    td10.appendChild(DOM_img);
		   
	    
	    td11.appendChild(text11);
	    td12.appendChild(text12);
	    
	    td13.appendChild(text13);
	    td14.appendChild(text14);
	    
	    tr.appendChild(td0);
	    tr1.appendChild(td1);
	    tr1.appendChild(td2);

	    tr2.appendChild(td3);
	    tr2.appendChild(td4);
	    
	    tr3.appendChild(td5);
	    tr3.appendChild(td6);
	    
	    tr4.appendChild(td7);
	    tr4.appendChild(td8);
	    
	    tr5.appendChild(td9);
	    tr5.appendChild(td10);
	    
	    tr6.appendChild(td11);
	    tr6.appendChild(td12);
	    
	    tr7.appendChild(td13);
	    tr7.appendChild(td14);
	    
	    table.appendChild(tr);
	    table.appendChild(tr1);
	    table.appendChild(tr2);
	    table.appendChild(tr3);
	    table.appendChild(tr4);
	    table.appendChild(tr5);
	    table.appendChild(tr6);
	    table.appendChild(tr7);
	}
	document.body.appendChild(table);
}