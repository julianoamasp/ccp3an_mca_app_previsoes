package com.usjt.Aula3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.usjt.Aula3.model.Cidade;
import com.usjt.Aula3.model.Dia;
import com.usjt.Aula3.model.Tempo;
import com.usjt.Aula3.service.DiaService;

@Controller
public class TempoController {

	@Autowired
	private DiaService diaService;
	
	@GetMapping("/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("listar");
		
		mv.addObject(new Tempo());
		mv.addObject(new Dia());
		
		List<Dia> dias = diaService.listar();
		
		mv.addObject("dias", dias);
		return mv;
	}
	
	
	@SuppressWarnings("finally")
	@PostMapping("/listar")
	public String cadastrar(Dia dia) {
		
		Cidade cidade = new Cidade();
		cidade.setNome(dia.getCidade().getNome());
		cidade.setLatitude(dia.getCidade().getLatitude());
		cidade.setLongitude(dia.getCidade().getLongitude());
		
		Tempo tempo = new Tempo();
		tempo.setTmax(dia.getTempo().getTmax());
		tempo.setTmin(dia.getTempo().getTmin());
		tempo.setHumidade(dia.getTempo().getHumidade());
		tempo.setDescricao(dia.getTempo().getDescricao());
		tempo.setData(dia.getTempo().getData());
		tempo.setLatitude(dia.getTempo().getLatitude());
		tempo.setLongitude(dia.getTempo().getLongitude());
	
		try {
		diaService.save(dia, tempo, cidade);
		}catch (Exception e) {
			System.out.print(e.getMessage());
		}finally {
		return "redirect:/listar";
		}
	}
}
