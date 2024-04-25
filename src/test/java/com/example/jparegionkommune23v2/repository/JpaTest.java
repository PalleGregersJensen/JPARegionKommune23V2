package com.example.jparegionkommune23v2.repository;

import com.example.jparegionkommune23v2.model.Kommune;
import com.example.jparegionkommune23v2.model.Region;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class JpaTest {

    @Autowired
    KommuneRepository kommuneRepository;

    @Autowired
    RegionRepository regionRepository;

    @Test
    void testGetKommuner() {
        List<Kommune> lst = kommuneRepository.findAll();
        assertNotEquals(0, lst.size());
    }

    @Test
    void countKommuner() {
        assertEquals(101, kommuneRepository.count());
    }

    @Test
    void testGetKommuneDelSave() {
        Optional<Kommune> rosOpt = kommuneRepository.findByNavn("Roskilde");
        if(rosOpt.isPresent()){
            Kommune ros = rosOpt.get();
            kommuneRepository.delete(ros);
            assertEquals(100, kommuneRepository.count(), "All good");
            kommuneRepository.save(ros);
            assertEquals(101, 101, "All good");
        } else{
            fail("Vi fik ikke Roskilde");
        }
    }


    @Test
    void testRegionCount() {
        Optional<Region> regionOptional = regionRepository.findById("1081");
        if(regionOptional.isPresent()){
            Set<Kommune> setKom = regionOptional.get().getKommuner();
            assertEquals(20, setKom.size(), "It works");
        }else{
            fail("Fandt ingen kommuner");
        }
    }

    @Test
    void testSetKommune(){
        Set<Kommune> setKom = new HashSet<>();
        Kommune k1 = new Kommune();
        k1.setKode("1");
        setKom.add(k1);
        Kommune k2 = new Kommune();
        k1.setKode("1");
        setKom.add(k2);
        assertEquals(2, setKom.size(), "Expected error");
    }

}
