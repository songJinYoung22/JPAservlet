package com.keduit.controller;

import com.keduit.controller.action.Action;
import com.keduit.controller.action.CheckIdAction;
import com.keduit.controller.action.GoMainAction;
import com.keduit.controller.action.InsertAction;
import com.keduit.controller.action.InsertFormAction;
import com.keduit.controller.action.LoginCheckAction;
import com.keduit.controller.action.LoginFormAction;
import com.keduit.controller.action.LogoutAction;
import com.keduit.controller.action.UpdateAction;
import com.keduit.controller.action.UpdateFormAction;


public class ActionFactory {
	// 싱글톤 디자인 패턴.
	// 프라이빗 디폴트 생성자로 함부로 초기화 할 수 없게 막음.
	// 프라이빗 스테틱 인스턴스 변수를 호출 시 초기화 되도록 함.(마찬가지 함부로 접근 불가?)
	// 엑션펙토리 타입의 갯인스턴스 함수를 호출 시에 인스턴스를 리턴함.
	// 직접 사용되는 부분은 겟 인스턴스 하나 뿐?
	private ActionFactory() {
	}

	private static ActionFactory instance = new ActionFactory();

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory : " + command);
		// 다형성. 부모의 매서드 action 으로 모든 자식의 메서드들을 다룸.
		if (command.equals("login_form")) {
			action = new LoginFormAction();
		}else if(command.equals("login_check")) {
			action = new LoginCheckAction();
		}else if(command.equals("update_form")) {
			action = new UpdateFormAction();
		}else if(command.equals("update")) {
			action = new UpdateAction();
		}else if(command.equals("go_main")) {
			action = new GoMainAction();
		}else if(command.equals("insert_form")) {
			action = new InsertFormAction();
		}else if(command.equals("check_id")) {
			action = new CheckIdAction();
		}else if(command.equals("insert")) {
			action = new InsertAction();
		}else if(command.equals("logout")) {
			action = new LogoutAction();
		}

		return action;

	}

}