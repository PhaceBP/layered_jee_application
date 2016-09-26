package hu.javaee.tranining.entities;

import java.util.HashSet;
import java.util.Set;


public class StockDTO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3445501128201510839L;
	private Integer stockId;
	private String stockCode;
	private String stockName;
	private Set<StockDailyRecordDTO> stockDailyRecords = new HashSet<StockDailyRecordDTO>(0);

	public StockDTO() {
	}

	public StockDTO(String stockCode, String stockName) {
		this.stockCode = stockCode;
		this.stockName = stockName;
	}

	public StockDTO(String stockCode, String stockName, Set<StockDailyRecordDTO> stockDailyRecords) {
		this.stockCode = stockCode;
		this.stockName = stockName;
		this.stockDailyRecords = stockDailyRecords;
	}

	public Integer getStockId() {
		return this.stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	public String getStockCode() {
		return this.stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public String getStockName() {
		return this.stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public Set<StockDailyRecordDTO> getStockDailyRecords() {
		return this.stockDailyRecords;
	}

	public void setStockDailyRecords(Set<StockDailyRecordDTO> stockDailyRecords) {
		this.stockDailyRecords = stockDailyRecords;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stockCode == null) ? 0 : stockCode.hashCode());
		result = prime * result + ((stockDailyRecords == null) ? 0 : stockDailyRecords.hashCode());
		result = prime * result + ((stockId == null) ? 0 : stockId.hashCode());
		result = prime * result + ((stockName == null) ? 0 : stockName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StockDTO other = (StockDTO) obj;
		if (stockCode == null) {
			if (other.stockCode != null)
				return false;
		} else if (!stockCode.equals(other.stockCode))
			return false;
		if (stockDailyRecords == null) {
			if (other.stockDailyRecords != null)
				return false;
		} else if (!stockDailyRecords.equals(other.stockDailyRecords))
			return false;
		if (stockId == null) {
			if (other.stockId != null)
				return false;
		} else if (!stockId.equals(other.stockId))
			return false;
		if (stockName == null) {
			if (other.stockName != null)
				return false;
		} else if (!stockName.equals(other.stockName))
			return false;
		return true;
	}
	
	

}
