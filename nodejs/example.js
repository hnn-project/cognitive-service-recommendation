/**
 * Cognitive service recommendation example
 * - Getting recommendation items with specific items.
 */
const request = require('request');

// API configurations
const API_URL = '{YOUR API URL WITHOUT PARAMETERS}';
const COGNITIVE_API_KEY = '{YOUR API KEY}';
const BUILD_ID = '{YOUR BUILD ID}';

// Item configurations
const ITEMS = [/* {TARGET ITEMS TO GET RECOMMENDATIONS} ex)'FKF-00829','C3T-00001']*/;
const NUMBER_OF_RESULTS = 5;
const MINIMAL_SCORE = 0;
const INCLUDE_METADATA = false;

request({
    method: 'GET',
    url: API_URL,
    qs: {
        'buildId': BUILD_ID,
        'itemIds': ITEMS.join(','),
        'numberOfResults': NUMBER_OF_RESULTS,
        'includeMetadata': INCLUDE_METADATA,
        'minimalScore': MINIMAL_SCORE
    },
    headers: {
        'Ocp-Apim-Subscription-Key': COGNITIVE_API_KEY
    }
}, (err, response, body) => {
    if (err) {
        console.error('Request failed', err);
        process.exit(1);
    }

    console.log(JSON.parse(body));
});