package Reuniao.controller;

import Reuniao.dto.ReuniaoRequestDTO;
import Reuniao.dto.ReuniaoResponseDTO;
import Reuniao.service.ReuniaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("reuniao")
public class ReuniaoController {
    private final ReuniaoService reuniaoService;

    @Autowired()
    public ReuniaoController(ReuniaoService reuniaoService) { this.reuniaoService = reuniaoService; }

    @PostMapping
    public void create(@RequestBody ReuniaoRequestDTO data) { reuniaoService.create(data); }

    @GetMapping
    public List<ReuniaoResponseDTO> getAll() { return reuniaoService.getAll(); }

    @GetMapping("{id}")
    public ReuniaoResponseDTO getOne(@PathVariable Long id) { return reuniaoService.getOne(id); }

    @PatchMapping("{id}")
    public void update(@PathVariable Long id, @RequestBody Map<String, Object> updates){
        reuniaoService.update(id, updates);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        reuniaoService.delete(id);
    }
}
