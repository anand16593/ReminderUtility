/*package com.cube.utility.processors;

import java.text.ParseException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cube.utility.beans.DuesCollection;
import com.cube.utility.entities.Dues;
import com.cube.utility.entities.Reminder;
import com.cube.utility.repositories.DuesRepository;
import com.cube.utility.util.DateUtil;

@Component
public class CubeDuesProcessor {

	private final DuesRepository duesRepository;

	@Autowired
	public CubeDuesProcessor(DuesRepository duesRepository) {
		this.duesRepository = duesRepository;
	}

	public void processDues(DuesCollection dues, Reminder reminder)
			throws ParseException {

		Dues due = new Dues(reminder, (dues.getCreatedISO() == null || dues
				.getCreatedISO().length() == 0) ? new Date()
				: DateUtil.getDateFromMongo(dues.getCreatedISO()), new Date(),
				dues.getAmount(), dues.getPaidVia(),
				dues.getReminderDate() != null ? new Date(dues
						.getReminderDate().longValue()) : null,
				dues.getForwardPhone(), dues.getForwardName(),
				dues.getPaidDate() != null ? new Date(dues.getPaidDate()
						.longValue()) : null, dues.getStatus(),
				dues.getTransactionId(), dues.getOrderId(),
				dues.getPaymentStatus(), dues.getServiceType(),
				dues.getUniqueId(), dues.getIdOrder(),
				(dues.getActive() != null && dues.getActive()) ? 1 : 0,
				(dues.getEnabled() != null && dues.getEnabled()) ? 1 : 0);

		duesRepository.save(due);
	}
}
*/