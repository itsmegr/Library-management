package com.librarymanagement.controllers;

import com.librarymanagement.reqresjsonformat.response.NormalResponse;
import com.librarymanagement.reqresjsonformat.response.Profile;
import com.librarymanagement.reqresjsonformat.response.SuccessfullySignedInResponse;
import com.librarymanagement.security.services.UserDetailsImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

  @GetMapping("/user")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
  public ResponseEntity<Profile> userAccess() {
    UserDetailsImpl obj  = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    return new ResponseEntity<Profile>(new Profile(obj.getId(), obj.getUsername(), obj.getRoles()), HttpStatus.OK);
  }

  @GetMapping("/admin")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<Profile> adminAccess() {
    UserDetailsImpl obj  = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    return new ResponseEntity<Profile>(new Profile(obj.getId(), obj.getUsername(), obj.getRoles()), HttpStatus.OK);
  }
}
