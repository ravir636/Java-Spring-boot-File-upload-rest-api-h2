package com.org.rbc.stock.market.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencsv.bean.CsvBindByName;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@Entity
public class StockData implements Serializable{
	
	@Id
	@GeneratedValue
	private Long id;
	@JsonProperty
	@CsvBindByName
	private String quarter;
	@JsonProperty
	@CsvBindByName
	private String stock;
	@JsonProperty
	@CsvBindByName
	private String date;
	@JsonProperty
	@CsvBindByName
	private String open;
	@JsonProperty
	@CsvBindByName
	private String high;
	@JsonProperty
	@CsvBindByName
	private String low;
	@JsonProperty
	@CsvBindByName
	private String close;
	@JsonProperty
	@CsvBindByName
	private String volume;
	@JsonProperty
	@CsvBindByName
	private String percent_change_price;
	@JsonProperty
	@CsvBindByName
	private String percent_change_volume_over_last_wk;
	@JsonProperty
	@CsvBindByName
	private String previous_weeks_volume;
	@JsonProperty
	@CsvBindByName
	private String next_weeks_open;
	@JsonProperty
	@CsvBindByName
	private String next_weeks_close;
	@JsonProperty
	@CsvBindByName
	private String percent_change_next_weeks_price;
	@JsonProperty
	@CsvBindByName
	private String days_to_next_dividend;
	@JsonProperty
	@CsvBindByName
	private String percent_return_next_dividend;
	
}
