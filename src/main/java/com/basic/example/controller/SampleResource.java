package com.basic.example.controller;

import com.basic.example.dto.Profile;
import com.basic.example.service.api.ProfileDataService;
import io.swagger.annotations.*;
import org.omg.PortableInterceptor.SUCCESSFUL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/employees")
@Api(value = "EmployeeAPI", description = "save employee details")
public class SampleResource {

    private static Logger logger = LoggerFactory.getLogger(SampleResource.class);

    @Autowired
    private ProfileDataService profileDataService;

    @POST
    @Path("/data")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Add a user", response = Profile.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 401, message = "You are not authorized access the resource"),
            @ApiResponse(code = 404, message = "The resource not found")})
    public ResponseEntity<?> profileDataEnrollment(@ApiParam(value = "Employee details", required = true) @RequestBody Profile profile) {

        try {
            profileDataService.saveEmployeeProfileDetails(profile);
            return new ResponseEntity<SUCCESSFUL>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Error>(HttpStatus.CONFLICT);
    }

    @GET
    @Path("/getEmployeeData/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Specific Employee Details", response = Profile.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Employee Details by ID",response = Profile.class),
            @ApiResponse(code = 401, message = "You are not authorized access the resource"),
            @ApiResponse(code = 404, message = "The resource not found")})
    public ResponseEntity<?> getStudent(@ApiParam(value = "id", required = true) @PathParam("id") long id) {
        logger.debug("START :: Retrieve Employee Details by ID : {}", id);
        Profile employee = profileDataService.getEmployeeProfileDetails(id);
        logger.debug("END :: Retrieve Employee Details by ID : {}", employee);
        return new ResponseEntity<Profile>(employee, HttpStatus.OK);
    }

    @PUT
    @Path("/updateemployeedata")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Update a user", response = Profile.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Employee details updated successfully"),
            @ApiResponse(code = 401, message = "You are not authorized to access the resource"),
            @ApiResponse(code = 404, message = "The resource not found")})
    public ResponseEntity<?> updateProfileDataEnrollment(@ApiParam(value = "Update employee details", required = true) @RequestBody Profile profile) {

        try {
            profileDataService.updateEmployeeProfileDetails(profile);
            return new ResponseEntity<SUCCESSFUL>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Error>(HttpStatus.CONFLICT);
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Delete a user", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "removed the employee"),
            @ApiResponse(code = 401, message = "You are not authorized access the resource"),
            @ApiResponse(code = 404, message = "The resource not found")})
    public ResponseEntity<?> removeProfileDataEnrollment(@ApiParam(value = "id", required = true) @PathParam("id")long id) {

        try {
            profileDataService.removeEmployeeProfileDetails(id);
            return new ResponseEntity<SUCCESSFUL>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Error>(HttpStatus.CONFLICT);
    }


    @Path("/getdatawithhighestid")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public long getEmployeeHighestID() {
        long profileWithHighestId = 0;
        try {
            profileWithHighestId = profileDataService.getEmployeeHighestID();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return profileWithHighestId;
    }

}
