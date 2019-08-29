package tws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tws.entity.Parkinglot;
import tws.repository.ParkingLotMapper;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/parkinglots")
public class ParkingLotController {

    @Autowired
    private ParkingLotMapper parkingLotMapper;

    @GetMapping("")
    public ResponseEntity<List<Parkinglot>> getAll() {
        return ResponseEntity.ok(parkingLotMapper.selectAll());
    }

    @PostMapping("")
    public ResponseEntity<Parkinglot> createEmployee(@RequestBody Parkinglot parkingLot) {
        parkingLotMapper.insert(parkingLot);
        return ResponseEntity.created(URI.create("/parkinglots/" + parkingLot.getParkinglotId())).body(parkingLot);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Parkinglot> updateEmployee(@PathVariable int id, @RequestBody Parkinglot parkingLot){
        parkingLotMapper.update(id,parkingLot);
        return ResponseEntity.ok(parkingLot);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEmployee(@PathVariable int id) {
        parkingLotMapper.deleteOne(id);
    }

}
