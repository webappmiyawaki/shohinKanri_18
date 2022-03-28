package model.shohin;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IsModel implements Serializable{
	private boolean isSearch;
	private boolean isDelete;
	public IsModel(){
		this.isDelete=false;
		this.isSearch=false;
	}
}
