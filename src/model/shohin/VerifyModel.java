package model.shohin;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VerifyModel implements Serializable{
	private boolean isSearched;
	private boolean isUpdated;
	private boolean isAdded;
	private boolean isDeleted;
}
