package tws.controller;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tws.entity.Parkingboy;
import tws.repository.ParkingBoyMapper;

@RestController
@RequestMapping("/parkingboy")
public class ParkingBoyController {
	
	@Autowired
	private ParkingBoyMapper parkingboyMapper;
	
	
    @PostMapping("/insert")
    public ResponseEntity<Parkingboy> insertEmployee(@RequestBody Parkingboy parkingboy) {
    	String parkingboyID = UUID.randomUUID().toString();
    	parkingboy.setParkingboyId(parkingboyID);;
    	parkingboyMapper.insertParkingBoy(parkingboy);
        return ResponseEntity.created(URI.create(URI.create("/employees")+parkingboy.getParkingboyId())).build();
    }

    @GetMapping("")
    public ResponseEntity<List<Parkingboy>> getAll() {
        return ResponseEntity.ok(parkingboyMapper.selectAll());
    }
    
}
