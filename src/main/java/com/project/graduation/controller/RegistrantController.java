package com.project.graduation.controller;

import com.project.graduation.domain.registrant.Registrant;
import com.project.graduation.repository.RegistrantRepository;
import com.project.graduation.service.RegistrantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor// final 객체를 Constructor Injection 해줌. (Autowired 역할)
@RestController //JSON 형태 결과값을 반환해줌 (@ResponseBody가 필요없음)
@RequestMapping("registrant")
public class RegistrantController {

    private final RegistrantService registrantService;
    private final RegistrantRepository registrantRepository;

    @GetMapping("/print")
    public List<Registrant> findAllMember(@RequestHeader("Authorization") String token) {
        String user_id = token.replace("TOKEN_", "");
        return registrantRepository.findByVariable(user_id);
    }

    @GetMapping("/add")
    public String printAddPage() {
        return "regi-add";
    }

    @GetMapping("/take")
    public String printTakePage() {
        //save service -> fileService.saveFile(file) -> 파일 DB에 먼저 올리기
        return "regi-name";
    }

    @PostMapping("/save") //이름과 함께 파일 불러와서 저장
    public void saveRegistrant(@RequestBody Registrant registrant, @RequestHeader("Authorization") String token) {
        String user_id = token.replace("TOKEN_", "");
        Registrant r = Registrant.builder().user_id(user_id).name(registrant.getName()).file_name(registrant.getFile_name()).build();
        registrantService.saveRegistrant(r);
    }

    @GetMapping("/delete")
    public void deleteRegistrant() {
        //delete service
    }

}
