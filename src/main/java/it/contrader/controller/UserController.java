package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import it.contrader.dto.LoginDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController extends AbstractController<UserDTO> {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    public ResponseEntity<UserDTO> login(@RequestBody @Valid LoginDTO loginDTO) {
        return new ResponseEntity<>(userService.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword()),
                HttpStatus.OK);
    }

    @GetMapping(value = "/logout")
    public ResponseEntity logout(HttpServletRequest request){
        request.getSession().invalidate();
        System.out.println(request);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(value = "/deleteuser")
    public ResponseEntity<UserDTO> deleteUser(@RequestParam("id") Long id) {
        UserDTO dto = new UserDTO();
        dto.setId(id);
        dto.setUsertype(null);
        dto.setPassword(null);
        dto.setUsername(null);
        return new ResponseEntity<>(userService.update(dto), HttpStatus.OK);
    }


}