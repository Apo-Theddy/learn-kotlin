package com.example.coingecko.features.data.data_source.dtos.CoinDetailDTO

data class CommunityData(
    val facebook_likes: Any,
    val reddit_accounts_active_48h: Int,
    val reddit_average_comments_48h: Int,
    val reddit_average_posts_48h: Int,
    val reddit_subscribers: Int,
    val telegram_channel_user_count: Any,
    val twitter_followers: Int
)