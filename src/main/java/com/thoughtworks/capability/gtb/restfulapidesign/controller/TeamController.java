package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Team;
import com.thoughtworks.capability.gtb.restfulapidesign.service.TeamService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/teams")
@Validated
public class TeamController {
    private TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("")
    public List<Team> getAllTeams(@Valid Team team){
        return teamService.getAllTeams();
    }
    @GetMapping("/{id}")
    public Team getTeamById(@PathVariable("id") @Min(1) Integer id){
        return teamService.getTeamById(id);
    }
    @PatchMapping("/{id}")
    public Team updateTeamName(@PathVariable("id") @Min(1) Integer id, @RequestBody Team team){
        return teamService.updateTeamById(id,team);
    }
}
