package com.basic.example.controller;

import com.basic.example.dto.Profile;
import com.basic.example.service.api.ProfileDataService;
import io.swagger.annotations.*;
import org.omg.PortableInterceptor.SUCCESSFUL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Component
@Path("/employees")
@Api(value="EmployeeAPI", description="save employee details")
public class SampleResource {

    @Autowired
    private ProfileDataService profileDataService;

    @ApiOperation(value = "Add a user",response = Profile.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 401, message = "You are not authorized access the resource"),
            @ApiResponse(code = 404, message = "The resource not found")
    })
    @Path("/data")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<?> profileDataEnrollment(@ApiParam(value = "Employee details", required = true) @RequestBody Profile profile) {

        try {
            profileDataService.saveUserProfileDetails(profile);
            return new ResponseEntity<SUCCESSFUL>(HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<Error>(HttpStatus.CONFLICT);
    }

    @Path("/getdata")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public long getprofileDatawithHighestID() {
        long profileWithHighestId=0;
        try {
             profileWithHighestId=profileDataService.getprofileDataHighestID();

        }catch (Exception e){
            e.printStackTrace();
        }
        return profileWithHighestId;
    }

}
