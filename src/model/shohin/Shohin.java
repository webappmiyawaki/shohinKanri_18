package model.shohin;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Shohin implements Serializable{
    private int shohin_id;
    private String shohin_mei;
    private String shohin_bunrui;
    private int hanbai_tanka;
    private int shiire_tanka;
    private String torokubi;
    private boolean isInteger_hanbai_tanka;
    private boolean isInteger_shiire_tanka;
    public String getStringShohin_id() {
    	return String.format("%04d", this.shohin_id);
    }

    @Override
    public String toString(){
        return String.format("%04d,%s,%s,%d,%d",
        		this.shohin_id,
        		this.shohin_mei,
        		this.shohin_bunrui,
        		this.hanbai_tanka,
        		this.shiire_tanka
        		);
    }
}
