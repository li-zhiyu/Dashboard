Ext.define('Ext.form.field.DateTime', {
	extend : 'Ext.form.field.Date',
	alias : 'widget.datetimefield',
	requires : [ 'Ext.picker.DateTime' ],
	format : "Y-m-d H:i:s",
	width : 180,
	createPicker : function() {
		var me = this, format = Ext.String.format;
		return new Ext.picker.DateTime({
			pickerField : me,
			floating : true,
			preventRefocus : true,
			hidden : true,
			minDate : me.minValue,
			maxDate : me.maxValue,
			disabledDatesRE : me.disabledDatesRE,
			disabledDatesText : me.disabledDatesText,
			ariaDisabledDatesText : me.ariaDisabledDatesText,
			disabledDays : me.disabledDays,
			disabledDaysText : me.disabledDaysText,
			ariaDisabledDaysText : me.ariaDisabledDaysText,
			format : me.format,
			showToday : me.showToday,
			startDay : me.startDay,
			minText : format(me.minText, me.formatDate(me.minValue)),
			ariaMinText : format(me.ariaMinText, me.formatDate(me.minValue,
					me.ariaFormat)),
			maxText : format(me.maxText, me.formatDate(me.maxValue)),
			ariaMaxText : format(me.ariaMaxText, me.formatDate(me.maxValue,
					me.ariaFormat)),
			listeners : {
				scope : me,
				select : me.onSelect,
				tabout : me.onTabOut
			},
			keyNavConfig : {
				esc : function() {
					me.inputEl.focus();
					me.collapse();
				}
			}
		});
	},

	onExpand : function() {
		var value = this.rawDate;
		this.picker.setValue(Ext.isDate(value) ? value : value, true);
	}
})
