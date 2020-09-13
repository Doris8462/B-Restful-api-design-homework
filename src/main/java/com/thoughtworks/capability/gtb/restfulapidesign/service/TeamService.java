package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Team;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.StudentAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeamService {
    private Map<Integer, Team> teamMap = new HashMap<>();

    public TeamService() {
        teamMap.put( 1 ,new Team(1, "team1","",null));
        teamMap.put( 2 ,new Team(2, "team2","",null));
        teamMap.put( 3 ,new Team(3, "team3","",null));
        teamMap.put( 4 ,new Team(4, "team4","",null));
        teamMap.put( 5 ,new Team(5, "team5","",null));
        teamMap.put( 6 ,new Team(6, "team6","",null));
    }
    public List<Team> getAllTeams() {
        return new ArrayList<>(teamMap.values());
    }
    public Team updateTeamById(Integer teamId,Team updateTeam){
        Team team=teamMap.get(teamId);
        team.setTeamName(updateTeam.getTeamName());
        team.setTeamNote(updateTeam.getTeamNote()==null?team.getTeamNote():updateTeam.getTeamNote());
        return team;
    }
}
