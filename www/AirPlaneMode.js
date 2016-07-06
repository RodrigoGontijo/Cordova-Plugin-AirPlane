/*
 * Phonegap AirPlaneMode Plugin for Android
 * Cordova 2.2.0
 * Email: rodrigo[dot]gontijo[at]hotmail[dot]com
 * Author: Rodrigo Augusto Gontijo
 * Date: 05/23/2016
 */

var exec = require('cordova/exec');

var AirPlaneMode = {
 	setAirPlaneModeOn: function(successCallback, failureCallback){
		return exec(
			successCallback,
			failureCallback,
			'AirPlaneMode',
			'setAirPlaneModeOn',
			[]);
	},

	setAirPlaneModeOff: function(successCallback, failureCallback){
		return exec(
			successCallback,
			failureCallback,
			'AirPlaneMode',
			'setAirPlaneModeOff',
			[]);
	},


	toggleAirPlaneMode: function(successCallback, failureCallback){
		return exec(
			successCallback,
			failureCallback,
			'AirPlaneMode',
			'toggleAirPlaneMode',
			[]);
	}

};

module.exports = AirPlaneMode;