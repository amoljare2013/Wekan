package com.ankit.jare.model

data class ListResponse(
        val station_locator_url: String,
        val total_results: Int,
        val fuel_stations: List<Fuel_stations>
)
data class Fuel_stations(
        val access_code: String,
        val access_days_time: String,
        val access_detail_code: String,
        val cards_accepted: String,
        val date_last_confirmed: String,
        val expected_date: String,
        val fuel_type_code: String,
        val groups_with_access_code: String,
        val id: Int,
        val open_date: String,
        val owner_type_code: String,
        val status_code: String,
        val station_name: String,
        val station_phone: String,
        val updated_at: String,
        val facility_type: String,
        val geocode_status: String,
        val latitude: Double,
        val longitude: Double,
        val city: String,
        val intersection_directions: String,
        val plus4: String,
        val state: String,
        val street_address: String,
        val zip: Int,
        val country: String,
        val bd_blends: String,
        val cng_dispenser_num: String,
        val cng_fill_type_code: String,
        val cng_psi: String,
        val cng_renewable_source: String,
        val cng_total_compression: String,
        val cng_total_storage: String,
        val cng_vehicle_class: String,
        val e85_blender_pump: String,
        val e85_other_ethanol_blends: String,
        val ev_connector_types: List<String>,
        val ev_dc_fast_num: String,
        val ev_level1_evse_num: Int,
        val ev_level2_evse_num: String,
        val ev_network: String,
        val ev_network_web: String,
        val ev_other_evse: String,
        val ev_pricing: String,
        val ev_renewable_source: String,
        val hy_is_retail: String,
        val hy_pressures: String,
        val hy_standards: String,
        val hy_status_link: String,
        val lng_renewable_source: String,
        val lng_vehicle_class: String,
        val lpg_primary: String,
        val lpg_nozzle_types: String,
        val ng_fill_type_code: String,
        val ng_psi: String,
        val ng_vehicle_class: String,
        val access_days_time_fr: String,
        val intersection_directions_fr: String,
        val bd_blends_fr: String,
        val groups_with_access_code_fr: String,
        val ev_pricing_fr: String
)