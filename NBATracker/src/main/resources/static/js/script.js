console.log("script.js loaded");

window.addEventListener('load', function(e){
	console.log('document loaded');
	init();

});

function init(){
	console.log('in init()')
	getTeams();
	
	document.newTeamForm.newTeamFormBtn.addEventListener('click', function(event){
		event.preventDefault();

		postNewTeam();
		getTeams();
		getTeams();
	});
}

function getTeams(){
	var xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/teams');
	

	xhr.onreadystatechange = function(){

		if(xhr.readyState === 4){
			if(xhr.status === 200){
				let data = JSON.parse(xhr.responseText);
				displayTeams(data);
				displayConferenceSplit(data);
			}
			else {
				let teamsDiv = document.getElementById('teamList');
				teamsDiv.textContent = 'No teams found.';
			}
		}
	}
	xhr.send();
}

function displayTeams(teams){
	let teamsDiv = document.getElementById('teamList');
	teamsDiv.textContent = '';
	console.log("inside displayTeams");
	
	let table = document.createElement('table');
	////////////////////////////
	// Table Header Creation //
	////////////////////////////
	let trHeader = document.createElement('tr');
	
	
	let thTeamName = document.createElement('th');
	thTeamName.textContent = "Team Name";
	trHeader.appendChild(thTeamName);
	
	let thTeamRoster = document.createElement('th');
	thTeamRoster.textContent = "Roster";
	trHeader.appendChild(thTeamRoster);
	
	let thTeamLogo = document.createElement('th');
	thTeamLogo.textContent = "Logo";
	trHeader.appendChild(thTeamLogo);
	
	let thTeamTwitter = document.createElement('th');
	thTeamTwitter.textContent = "Twitter account";
	trHeader.appendChild(thTeamTwitter);
	
	let thTeamCity = document.createElement('th');
	thTeamCity.textContent = "City";
	trHeader.appendChild(thTeamCity);
	
	let thTeamVenue = document.createElement('th');
	thTeamVenue.textContent = "Venue";
	trHeader.appendChild(thTeamVenue);
	
	let thTeamConference = document.createElement('th');
	thTeamConference.textContent = "Conference";
	trHeader.appendChild(thTeamConference);
	
	
	
	table.appendChild(trHeader);
	
	  ///////////////////////////////////////
	 // Displays all data from each team ///
	///////////////////////////////////////
	
	teams.forEach(function(team, index){
		let tr = document.createElement('tr');

		
		let teamName = document.createElement('td');
		teamName.textContent = team.name;
		tr.appendChild(teamName);
		
		//COME BACK LOGIC TO SHOW ALL PLAYERS
		let teamRoster = document.createElement('td');
		teamRoster.textContent = team.roster;
		tr.appendChild(teamRoster);
		
		//LOOK INTO HAVING THE IMAGE DISPLAY FROM URL
		let teamLogo = document.createElement('td');
		teamLogo.textContent = team.logoUrl;
		tr.appendChild(teamLogo);
		
		//LOOK INTO HAVING A HYPERLINK HREF?
		let teamTwitter = document.createElement('td');
		teamTwitter.textContent = team.twitterUrl;
		tr.appendChild(teamTwitter);
		
		let teamCity = document.createElement('td');
		teamCity.textContent = team.city;
		tr.appendChild(teamCity);
		
		let teamVenue = document.createElement('td');
		teamVenue.textContent = team.venue;
		tr.appendChild(teamVenue);
		
		let teamConference = document.createElement('td');
		teamConference.textContent = team.conference;
		tr.appendChild(teamConference);
		
		
		/////Display Form when click on Team row on table///////
		tr.addEventListener('click', function(e){
			e.preventDefault();
			let div = document.getElementById('editTeamFormDiv');
			div.textContent = '';
			
			let h3 = document.createElement('h3');
			h3.textContent = "Edit team: ";
			div.appendChild(h3);
			
			
			////////////CLONE FORM (newTeamForm)/////////
			let form = document.querySelector('#newTeamForm');
			let clone = form.cloneNode(true);
			clone.id = 'editTeamForm';
			clone.classList.add('text-large');
			
			clone.name.value = team.name;
			clone.logoUrl.value = team.logoUrl;
			clone.city.value = team.city;
			clone.twitterUrl.value = team.twitterUrl;
			clone.venue.value = team.venue;
			clone.conference.value = team.conference;
			
			clone.removeChild(clone.newTeamFormBtn);
			
			
			//////////Update Button Functionality ///////////
			let updateButton = document.createElement('button');
			updateButton.textContent = "Update";
			updateButton.addEventListener('click', function(event){
				event.preventDefault();
				updateTeam(team);
				getTeams();
				getTeams();
				
			});
			
			//////////Delete Button Functionality ///////////
			let deleteButton = document.createElement('button');
			deleteButton.textContent = "Delete";
			deleteButton.addEventListener('click', function(event){
				event.preventDefault();
				deleteTeam(team);
				div.textContent = '';
				getTeams();
				getTeams();
				
			});
			
			clone.appendChild(updateButton);
			clone.appendChild(deleteButton);
			
			
			
			h3.after(clone);
			
		});

		table.appendChild(tr);
		
	});
	
	teamsDiv.appendChild(table);
}

	  //////////////////////////////
	 /// POST new Team from form///
	//////////////////////////////
function postNewTeam(){
	let form = document.getElementById('newTeamForm');
	
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'api/teams');
	
	xhr.setRequestHeader("Content-type", "application/json");
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4){
			if(xhr.status == 200 || xhr.status == 201){
				let data = JSON.parse(xhr.responseText);
				console.log("INSIDE SUCCESSFUL TEAM POST");
				
			}
			else{
				console.log("POST request failed.");
     			console.error(xhr.status + ': ' + xhr.responseText);
			}
		}	
	};
	
	let nName = document.newTeamForm.name.value;
	let nLogo = document.newTeamForm.logoUrl.value;
	let nCity = document.newTeamForm.city.value;
	let nTwitter = document.newTeamForm.twitterUrl.value;
	let nVenue = document.newTeamForm.venue.value;
	let nConference = document.newTeamForm.conference.value;
	
	var newTeam = {
		name : nName,
		logoUrl : nLogo,
		city : nCity,
		twitterUrl : nTwitter,
		venue : nVenue,
		conference : nConference
		
	};
	var newTeamJson = JSON.stringify(newTeam);
	
	xhr.send(newTeamJson);
	
	document.newTeamForm.name.value = '';
	document.newTeamForm.logoUrl.value = '';
	document.newTeamForm.city.value = '';
	document.newTeamForm.twitterUrl.value = '';
	document.newTeamForm.venue.value = '';
	document.newTeamForm.conference.value = '';
	
	
}

	  //////////////////////////////
	 /// UPDATE Team from form/////
	//////////////////////////////

function updateTeam(team){
	
	let xhr = new XMLHttpRequest();
	xhr.open('PUT', 'api/teams/' + team.id);
	xhr.setRequestHeader("Content-type", "application/json");
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4){
			if(xhr.status === 200 || xhr.status === 201){
				var updatedTeam = JSON.parse(xhr.responseText);
				
			}
			else{
				console.log("UPDATE request failed.");
     			console.error(xhr.status + ': ' + xhr.responseText);
			}
		}
	};
	let editForm = document.getElementById('editTeamForm');
	
	team.name = editForm.name.value;
	team.logoUrl = editForm.logoUrl.value;
	team.city = editForm.city.value;
	team.twitterUrl = editForm.twitterUrl.value;
	team.venue = editForm.venue.value;
	team.conference = editForm.conference.value;
	
	xhr.send(JSON.stringify(team));
		
	
}

	  //////////////////////////////
	 /// DELETE Team from form/////
	//////////////////////////////

function deleteTeam(team){
	let xhr = new XMLHttpRequest();
	xhr.open('DELETE', 'api/teams/' + team.id);
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4){
			if(xhr.status === 200 || xhr.status === 204){
				console.log("Delete good")				
			}
			else{
				console.log("UPDATE request failed.");
     			console.error(xhr.status + ': ' + xhr.responseText);
			}
		}
	};
	xhr.send();

	
}

function displayConferenceSplit(teams){
	let westernCount = 0;
	let easternCount = 0;
	let conferenceSplitDiv = document.getElementById('conferenceSplitDiv');
	let h3 = document.createElement('h3');
	h3.textContent = 'Conference Split: '
	conferenceSplitDiv.textContent = '';
	conferenceSplitDiv.appendChild(h3);
	
	teams.forEach(function(team){
		if(team.conference === 'Western'){
			westernCount++;
		}
		else if(team.conference === 'Eastern'){
			easternCount++;
		}
	});
	let conferenceSplit = 'Western Conference: ' + westernCount + '	| Eastern Conference: ' + easternCount;
	let p = document.createElement('p');
	p.textContent = conferenceSplit;
	conferenceSplitDiv.appendChild(p);
	
		
}
