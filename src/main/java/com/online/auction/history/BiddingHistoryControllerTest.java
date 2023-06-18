
package com.online.auction.history;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.online.auction.entity.Auction;
import com.online.auction.entity.Bid;
import com.online.auction.entity.User;
import com.online.auction.history.impl.BiddingHistoryServiceImpl;
import com.online.auction.repository.BidRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class BiddingHistoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private BiddingHistoryServiceImpl biddingHistoryService;

    @InjectMocks
    private BiddingHistoryController biddingHistoryController;

    private ObjectMapper objectMapper;

    private List<BiddingHistory> biddingHistories;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        objectMapper = new ObjectMapper();
        biddingHistories = new ArrayList<>();
        User user = new User();
        user.setId(1L);
        user.setUsername("testuser");
        Auction auction = new Auction();
        auction.setId(1L);
        auction.setName("testauction");
        Bid bid = new Bid();
        bid.setId(1L);
        bid.setBidder(user);
        bid.setAuction(auction);
        bid.setAmount(new BigDecimal("100.00"));
        bid.setCreatedDate(LocalDateTime.now());
        bid.setIsWinningBid(true);
        BiddingHistory biddingHistory = new BiddingHistory(
                bid.getId(),
                bid.getBidder(),
                bid.getAuction(),
                bid.getAmount(),
                bid.getCreatedDate(),
                bid.getIsWinningBid()
        );
        biddingHistories.add(biddingHistory);
    }

    @Test
    public void testGetBiddingHistoryByUserId() throws Exception {
        when(biddingHistoryService.getBiddingHistoryByUserId(any(Long.class))).thenReturn(biddingHistories);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/bidding-history/user/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        List<BiddingHistory> response = objectMapper.readValue(content, objectMapper.getTypeFactory().constructCollectionType(List.class, BiddingHistory.class));
        assert response.size() == 1;
        assert response.get(0).getId() == 1L;
        assert response.get(0).getBidder().getId() == 1L;
        assert response.get(0).getAuction().getId() == 1L;
        assert response.get(0).getAmount().equals(new BigDecimal("100.00"));
        assert response.get(0).getIsWinningBid();
    }

    @Test
    public void testGetBiddingHistoryByAuctionId() throws Exception {
        when(biddingHistoryService.getBiddingHistoryByAuctionId(any(Long.class))).thenReturn(biddingHistories);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/bidding-history/auction/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        List<BiddingHistory> response = objectMapper.readValue(content, objectMapper.getTypeFactory().constructCollectionType(List.class, BiddingHistory.class));
        assert response.size() == 1;
        assert response.get(0).getId() == 1L;
        assert response.get(0).getBidder().getId() == 1L;
        assert response.get(0).getAuction().getId() == 1L;
        assert response.get(0).getAmount().equals(new BigDecimal("100.00"));
        assert response.get(0).getIsWinningBid();
    }

    @Test
    public void testGetWinningBidsByUserId() throws Exception {
        when(biddingHistoryService.getWinningBidsByUserId(any(Long.class))).thenReturn(biddingHistories);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/bidding-history/winning-bids/user/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        List<BiddingHistory> response = objectMapper.readValue(content, objectMapper.getTypeFactory().constructCollectionType(List.class, BiddingHistory.class));
        assert response.size() == 1;
        assert response.get(0).getId() == 1L;
        assert response.get(0).getBidder().getId() == 1L;
        assert response.get(0).getAuction().getId() == 1L;
        assert response.get(0).getAmount().equals(new BigDecimal("100.00"));
        assert response.get(0).getIsWinningBid();
    }
}
