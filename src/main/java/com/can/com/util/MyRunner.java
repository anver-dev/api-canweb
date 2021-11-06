package com.can.com.util;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.can.com.model.Center;
import com.can.com.model.Pet;
import com.can.com.security.enums.RolName;
import com.can.com.security.model.Rol;
import com.can.com.security.model.User;
import com.can.com.security.service.RolService;
import com.can.com.security.service.UserService;
import com.can.com.service.CenterService;
import com.can.com.service.PetService;

@Component
public class MyRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

    @Autowired
    private UserService userService;
    
    @Autowired
    private CenterService centerService;
    
    @Autowired
    private PetService petService;
    
    @Autowired
    private RolService rolService;
    
    @Autowired
	private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
    	/**
    	 * 
    	rolService.save(new Rol(RolName.ROL_ADMIN));
    	rolService.save(new Rol(RolName.ROL_CENTER));
    	rolService.save(new Rol(RolName.ROL_USER));
    	
    	User userAdmin = userService.save(new User("Karina", "admin", "admincan@email.com",
				passwordEncoder.encode("admin")));
    	
    	Set<Rol> rolesAdmin = new HashSet<Rol>();
		rolesAdmin.add(rolService.getRolByName(RolName.ROL_ADMIN).get());
    	
		userAdmin.setRoles(rolesAdmin);

		userService.save(userAdmin);
		
    	User userCenter = userService.save(new User("CenterTest", "center", "center@email.com",
    			passwordEncoder.encode("center")));
    	
    	Set<Rol> rolesCenter = new HashSet<Rol>();
		rolesCenter.add(rolService.getRolByName(RolName.ROL_CENTER).get());
    	
		userCenter.setRoles(rolesCenter);
    	
    	@SuppressWarnings({ "rawtypes", "unchecked" })
		Set<Pet> petsCenterTest = new HashSet();
    	
    	
    	Pet petTestGato = new Pet("Kira", 1, "En adopcion", "");
    	Pet petTestPerro = new Pet("Azus", 5, "En adopcion", "");
    	
    	petTestGato = petService.save(petTestGato);
    	petTestPerro = petService.save(petTestPerro);
    	
    	Center centerTest = new Center(); 			
    	
    	centerTest.setUser(userCenter);
    	

		userService.save(userAdmin);
    	
    	centerTest = centerService.save(centerTest);
    	
    	petsCenterTest.add(petTestGato);
    	petsCenterTest.add(petTestPerro);
    	
    	centerTest.setPets(petsCenterTest);
    	
    	centerService.save(centerTest);
    	 */
    }
}
