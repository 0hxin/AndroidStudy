package com.example.androidphone.service;

import com.example.androidphone.model.Phone;
import com.example.androidphone.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService {
    @Autowired
    private PhoneRepository phoneRepository;

    // 전체보기
    public List<Phone> list() throws Exception {
        return phoneRepository.findAll();
    }

    // 추가
    public Phone insert(Phone phone) throws Exception{
        return phoneRepository.save(phone);
    }

    // 수정
    public Phone update(Long id, Phone phone) throws Exception{
        Phone updatePhone = phoneRepository.findById(id).orElseThrow(() -> new RuntimeException("데이터가 없습니다."));

        updatePhone.setName(phone.getName());
        updatePhone.setPhone(phone.getPhone());

        return phoneRepository.save(updatePhone);
    }

    // 삭제
    public void delete(Long id) throws Exception{
        phoneRepository.deleteById(id);
    }
}
