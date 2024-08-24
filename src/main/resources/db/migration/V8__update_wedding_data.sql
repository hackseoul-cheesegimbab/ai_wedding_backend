insert into wedding_data(wedding_flag, name, city, district, address, phone, price, description)
SELECT
    1, concat(ie.enterprise_name, '_', iwh.name),
    iwh.city, iwh.district, iwh.road_address,
    iwh.contact,
    floor(((iwh.min_artificial_fee + iwh.min_direct_fee + (iwh.min_person * iwh.min_food_fee)
        + iwh.min_real_fee + iwh.min_use_fee + iwh.min_external_fee) +
           (iwh.max_artificial_fee + iwh.max_direct_fee + (iwh.max_food_fee * iwh.max_person) +
            iwh.max_real_fee + iwh.max_use_fee + iwh.max_external_fee)) / 2),
    iwh.description
FROM iwedding_enterprise ie INNER JOIN iwedding_wedding_hall iwh ON ie.enterprise_code = iwh.enterprise_code
WHERE iwh.district IS NOT NULL AND iwh.city IS NOT NULL
