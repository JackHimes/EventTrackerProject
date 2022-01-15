console.log("script.js loaded");

window.addEventListener('load', function(e){
	console.log('document loade');
	init();

});

function init(){
	console.log('in init()')
	// TODO - set up event listener for forms, etc.
	getTeams();
}

function getTeams(){
	var xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/teams');
	
		console.log("inside getTeam() before readystate change");

	xhr.onreadystatechange = function(){
		if(xhr.readystate === 4){
				console.log("ready state 4 INSIDE IF STMT");
			if(xhr.status === 200){
				let data = JSON.parse(xhr.responseText);
				console.log("STATUS 200 INSIDE IF STMT");
				displayTeams(data);
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
	trHeader.appendChild(thTeamHead);
	
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
	
	let thTeamCoaches = document.createElement('th');
	thTeamCoaches.textContent = "Coaching Staff";
	trHeader.appendChild(thTeamCoaches);
	
	
	table.appendChild(trHeader);
	teamsDIv.appendChild(table);
	
}
