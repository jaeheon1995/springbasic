package com.example.springbasic.service.implement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springbasic.DTO.PostSample1Request;
import com.example.springbasic.entity.SampleTable1Entity;
import com.example.springbasic.repository.SampleTable1Repository;
import com.example.springbasic.service.SampleService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SampleServiceImplement implements SampleService{
    private final SampleTable1Repository SampleTable1Repository;


    @Override
    public ResponseEntity<String> postSample1(PostSample1Request dto) {
        //create(sql:insert)
        //1.entity 클래스의 인스턴스생성
        
        String sampeId = dto.getSampleId();
        Integer sampleColumn = dto.getSampleColumn();

    // select(sql:select)
    //  1.repository 를 이용하여 조회 (findAll,findById)
    // SampleTable1Entity existEntity=SampleTable1Repository.findById(sampeId).get();
    // 2.repository 를 이용하여 조회(existsById)
    boolean isExisted= SampleTable1Repository.existsById(sampeId);
    if(isExisted) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("이미 존재하는 기본키입니다.");

        SampleTable1Entity entity= new SampleTable1Entity(sampeId,sampleColumn);
    //2. 생성한 인스턴스를 리포지토리를 이용하여 저장
    //save() 저장 :
    // - 만약에 primary key가 동일한 레코드가 존재하지 않으면 레코드 생성
    // - 동일한 레코드가 존재하면 수정
        SampleTable1Repository.save(entity);

        return ResponseEntity.status(HttpStatus.CREATED).body("성공");
    }
}
